package com.khusan.ms1.api.impl;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.khusan.ms1.api.GeoCageService;
import com.khusan.ms1.api.HotelService;
import com.khusan.ms1.api.config.OpenCageServiceConfig;
import com.khusan.ms1.api.dto.Hotel;
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
  private final HotelService hotelService;

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

  @Override
  public Optional<Map<String, String>> getGeoPosition(final HotelDto place) {

    var hOptional = hotelService.findHotel(place);
    if (hOptional.isPresent()
        && hOptional.get().getLatitude() != null
        && hOptional.get().getLongtitude() != null) {
      return Optional.of(
          hotelDataToMap(hOptional.get().getLatitude(), hOptional.get().getLongtitude()));
    } else {
      var latLon = getGeoPosition(place.getAddress(), place.getCountry());
      hotelService.putHotel(
          latLon
              .map(
                  latLonMap -> {
                    place.setLatitude(latLon.get().get("lat"));
                    place.setLongtitude(latLon.get().get("lon"));
                    return place;
                  })
              .get());
      return latLon;
    }
  }

  private Map<String, String> hotelDataToMap(String latValue, String lonValue) {
    return Map.of("lat", latValue, "lon", lonValue);
  }
}
