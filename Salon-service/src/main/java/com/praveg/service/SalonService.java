package com.praveg.service;

import com.praveg.dto.SalonDto;
import com.praveg.dto.UserDto;
import com.praveg.entity.Salon;

import java.util.List;

public interface SalonService {

    Salon createSalon(SalonDto req, UserDto user);    // userdto who own this salon
    Salon getSalonById(Long salonId) throws Exception;
    List<Salon> getAllSalons();
    Salon updateSalon(SalonDto salon, UserDto user, Long salonId) throws Exception;
    void deleteSalonById(Long salonId) throws Exception;

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCity(String name);
}
