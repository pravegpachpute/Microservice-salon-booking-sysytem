package com.praveg.service.impl;

import com.praveg.dto.SalonDto;
import com.praveg.dto.UserDto;
import com.praveg.entity.Salon;
import com.praveg.repository.SalonRepository;
import com.praveg.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDto req, UserDto user) {
        Salon salon = new Salon();
        salon.setName(req.getName());
        salon.setAddress(req.getAddress());
        salon.setEmail(req.getEmail());
        salon.setCity(req.getCity());
        salon.setPhoneNumber(req.getPhoneNumber());
        salon.setImages(req.getImages());
        salon.setOwnerId(user.getId());
        salon.setOpenTime(req.getOpenTime());
        salon.setCloseTime(req.getCloseTime());
        return salonRepository.save(salon);
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if (salon == null){
            throw new Exception("Salon not exist...");
        }
        return salon;
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon updateSalon(SalonDto salon, UserDto user, Long salonId) throws Exception {
        Salon existingSalon = salonRepository.findById(salonId).orElse(null);
        if(existingSalon != null && salon.getOwnerId().equals(user.getId())){    // only owner can update own salon
            existingSalon.setName(salon.getName());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setCity(salon.getCity());
            existingSalon.setPhoneNumber(salon.getPhoneNumber());
            existingSalon.setImages(salon.getImages());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());
            existingSalon.setOwnerId(user.getId());

            return salonRepository.save(existingSalon);
        }
        throw new Exception("Salon not exist...");
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String name) {
        return salonRepository.searchSalons(name);
    }

    @Override
    public void deleteSalonById(Long salonId) throws Exception {
        Optional<Salon> optionalSalon = salonRepository.findById(salonId);
        if (optionalSalon.isEmpty()) {
            throw new Exception("User not found");
        }
        salonRepository.deleteById(optionalSalon.get().getId());
    }
}
