package com.khusan.ms1.api.repository;

import com.khusan.ms1.api.dto.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

  @Query(value = "")
  Hotel findBy(String name, String address, String city, String country);
}
