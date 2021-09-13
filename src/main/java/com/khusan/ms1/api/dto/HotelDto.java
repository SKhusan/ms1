package com.khusan.ms1.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

  private String id;
  private String name;
  private String address;
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
