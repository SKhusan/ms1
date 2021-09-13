package com.khusan.ms1.api;

import com.khusan.ms1.api.dto.HotelDto;
import java.util.Map;
import java.util.Optional;

public interface GeoCageService {
  Optional<Map<String, String>> getGeoPosition(String place, String country);

  Optional<Map<String, String>> getGeoPosition(HotelDto place);
}
