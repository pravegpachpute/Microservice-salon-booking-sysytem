package com.praveg.mapper;

import com.praveg.dto.SalonDto;
import com.praveg.entity.Salon;

public class SalonMapper {

    public static SalonDto mapToDTO(Salon salon){
        SalonDto salonDto = new SalonDto();
        salonDto.setId(salon.getId());

        salonDto.setName(salon.getName());
        salonDto.setCity(salon.getCity());
        salonDto.setAddress(salon.getAddress());
        salonDto.setEmail(salon.getEmail());
        salonDto.setPhoneNumber(salon.getPhoneNumber());
        salonDto.setImages(salon.getImages());
        salonDto.setOpenTime(salon.getOpenTime());
        salonDto.setCloseTime(salon.getCloseTime());
        salonDto.setOwnerId(salon.getOwnerId());
        return salonDto;
    }
}
