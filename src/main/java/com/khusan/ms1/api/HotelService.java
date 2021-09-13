package com.khusan.ms1.api;

import com.khusan.ms1.api.dto.Hotel;
import com.khusan.ms1.api.dto.HotelDto;
import java.util.Optional;

public interface HotelService {
  Optional<Hotel> findHotel(HotelDto hotelDto);

  void putHotel(HotelDto hotelDto);
}
