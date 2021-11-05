package com.khusan.ms1.api.dto;

import static com.khusan.ms1.api.utils.Constants.COLLECTION_NAME;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = COLLECTION_NAME)
public class HotelDto {

  @Id @Indexed private String id;
  @Indexed private String name;
  @Indexed private String address;
  private String city;
  private String country;
  private String longtitude;
  private String latitude;

  public HotelDto(HotelDto hotelDto) {
    this.id = hotelDto.getId();
    this.name = hotelDto.getName();
    this.address = hotelDto.getAddress();
    this.city = hotelDto.getCity();
    this.country = hotelDto.getCountry();
    this.longtitude = hotelDto.getLongtitude();
    this.latitude = hotelDto.getLatitude();
  }

  @Override
  public String toString() {
    return "HotelDto{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", address='"
        + address
        + '\''
        + ", city='"
        + city
        + '\''
        + '\''
        + '}';
  }
}
