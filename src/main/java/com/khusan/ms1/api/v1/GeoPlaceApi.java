package com.khusan.ms1.api.v1;

import com.khusan.ms1.api.GeoCageService;
import com.khusan.ms1.api.dto.HotelDto;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/geocode")
public class GeoPlaceApi {

  private final GeoCageService geoCageService;

  public GeoPlaceApi(GeoCageService geoCageService) {
    this.geoCageService = geoCageService;
  }

  @PostMapping
  public ResponseEntity<Map<String, String>> findGeoCodes(@RequestBody final HotelDto hotelDto) {
    log.info("Request for place: {}", hotelDto);
    return ResponseEntity.of(geoCageService.getGeoPosition(hotelDto));
  }
}
