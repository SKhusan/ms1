package com.khusan.ms1.api.impl;

import static com.khusan.ms1.api.utils.HotelDtoUtils.extractLatLonOptional;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.khusan.ms1.api.GeoCageService;
import com.khusan.ms1.api.config.OpenCageServiceConfig;
import com.khusan.ms1.api.dto.HotelDto;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public final class GeoCageServiceImpl implements GeoCageService {

  private final OpenCageServiceConfig serviceConfig;
  private final HotelDataServiceImpl hotelDataService;

  @Override
  public Optional<Map<String, String>> getGeoPosition(final String place, final String country) {
    log.info("Params: {}", place);
    var jOpenCageGeocoder = new JOpenCageGeocoder(serviceConfig.getApiKey());
    var request = new JOpenCageForwardRequest(place);
    request.setRestrictToCountryCode(country.toLowerCase());

    var response = jOpenCageGeocoder.forward(request);
    if (response.getTotalResults() > 0) {
      var firstResultLatLng = response.getFirstPosition();

      return Optional.of(
          hotelDataToMap(
              String.valueOf(firstResultLatLng.getLat()),
              String.valueOf(firstResultLatLng.getLng())));
    }

    return Optional.empty();
  }

  @Override //FixMe Should be added exceptional situation when record couldn't be saved on repo
  public Optional<Map<String, String>> getGeoPosition(final HotelDto place) {
    var hotelFromCache = hotelDataService.findHotelDto(place);
    if (hotelFromCache.isPresent()) {
      return extractLatLonOptional(place);
    } else {
      var result = getGeoPosition(place.getAddress(), place.getCountry());
      if (result.isPresent()) {
        var latLon = result.get();
        place.setLatitude(latLon.get("lat"));
        place.setLongtitude(latLon.get("lon"));
        hotelDataService.saveHotelDto(place);
      }
      return result;
    }
  }

  private Map<String, String> hotelDataToMap(String latValue, String lonValue) {
    return Map.of("lat", latValue, "lon", lonValue);
  }
}
