package com.khusan.ms1.api.impl;

import com.khusan.ms1.api.dto.HotelDto;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public final class HotelDataServiceImpl {
  private final MongoTemplate mongoTemplate;

  public final Optional<HotelDto> findHotelDto(final HotelDto hotelDto) {
    var query = new Query();
    if (!hotelDto.getName().isBlank() && !hotelDto.getAddress().isBlank()) {
      query.addCriteria(
          Criteria.where("name")
              .is(hotelDto.getName())
              .andOperator(Criteria.where("address").is(hotelDto.getAddress())));
    } else if (!hotelDto.getName().isBlank() && !hotelDto.getCountry().isBlank()) {
      query.addCriteria(
          Criteria.where("name")
              .is(hotelDto.getName())
              .andOperator(Criteria.where("country").is(hotelDto.getCountry())));
    } else if (!hotelDto.getName().isBlank()) {
      query.addCriteria(Criteria.where("name").is(hotelDto.getName()));
    }

    return Optional.ofNullable(mongoTemplate.findOne(query, HotelDto.class));
  }

  public final Optional<HotelDto> saveHotelDto(final HotelDto hotelDto) {
    return Optional.of(mongoTemplate.save(hotelDto));
  }
}
