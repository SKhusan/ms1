package com.khusan.ms1.api.impl;

import com.khusan.ms1.api.HotelService;
import com.khusan.ms1.api.dto.Hotel;
import com.khusan.ms1.api.dto.HotelDto;
import com.khusan.ms1.api.repository.HotelRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public final class HotelServiceImpl implements HotelService {

  private final HotelRepository hotelRepository;

  @Override
  public Optional<Hotel> findHotel(final HotelDto hotelDto) {
    log.info("Trying to find hotel from database: {}", hotelDto);
    return hotelRepository.findById(hotelDto.getId());
  }

  @Override
  public void putHotel(final HotelDto hotelDto) {
    log.info("Trying to put hotel to database: {}", hotelDto);
    hotelRepository.save(new Hotel(hotelDto));
  }
}
