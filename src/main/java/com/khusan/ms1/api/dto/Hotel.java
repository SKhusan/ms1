package com.khusan.ms1.api.dto;

import static com.khusan.ms1.api.utils.Constants.COLLECTION_NAME;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = COLLECTION_NAME)
public class Hotel {

  @Id @Indexed private String id;

  @Field(name = "created")
  @CreatedDate
  private Long created;

  @Field(name = "longtitude")
  private String longtitude;

  @Field(name = "latitude")
  private String latitude;

  public Hotel(final HotelDto hotelDto) {
    this.id = hotelDto.getId();
    this.longtitude = hotelDto.getLongtitude();
    this.latitude = hotelDto.getLatitude();
  }
}
