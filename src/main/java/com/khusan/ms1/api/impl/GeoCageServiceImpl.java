package com.khusan.ms1.api.impl;

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
      return getGeoPosition(place.getAddress(), place.getCountry());
  }

  private Map<String, String> hotelDataToMap(String latValue, String lonValue) {
    return Map.of("lat", latValue, "lon", lonValue);
  }
}
