package com.khusan.ms1.api.utils;

import com.khusan.ms1.api.dto.HotelDto;
import java.util.Map;
import java.util.Optional;

public class HotelDtoUtils {
  public static Map<String, String> extractLatLon(final HotelDto hotelDto) {
    return Map.of("lat", hotelDto.getLatitude(), "lon", hotelDto.getLongtitude());
  }

  public static Optional<Map<String, String>> extractLatLonOptional(final HotelDto hotelDto) {
    return Optional.of(extractLatLon(hotelDto));
  }
}
