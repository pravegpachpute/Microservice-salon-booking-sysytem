package com.praveg.controller;

import com.praveg.dto.SalonDto;
import com.praveg.dto.UserDto;
import com.praveg.entity.Salon;
import com.praveg.mapper.SalonMapper;
import com.praveg.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salon")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    // check
    @PostMapping("/create")
    public ResponseEntity<SalonDto> createSalon(@RequestBody SalonDto salonDto){
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        Salon salon = salonService.createSalon(salonDto, userDto);
        SalonDto salonDto1 = SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDto1, HttpStatus.CREATED);
    }

    // check
    @PatchMapping("/update/{salonId}")
    public ResponseEntity<SalonDto> updateSalon(@PathVariable Long salonId,
                                                @RequestBody SalonDto salonDto) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        Salon salon = salonService.updateSalon(salonDto, userDto, salonId );
        SalonDto salonDto1 = SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDto1, HttpStatus.OK);
    }

    // check
    @GetMapping("/getAll")
    public ResponseEntity<List<SalonDto>> getAllSalons() throws Exception {
        List<Salon> salons = salonService.getAllSalons();

        List<SalonDto> salonDtoList = salons.stream().map((salon) ->
        {
            SalonDto salonDto = SalonMapper.mapToDTO(salon);
            return  salonDto;
        }
        ).toList();
        return new ResponseEntity<>(salonDtoList, HttpStatus.OK);
    }

    // check
    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDto> getSalonById(@PathVariable Long salonId)
            throws Exception {
        Salon salon = salonService.getSalonById(salonId);
        SalonDto salonDto1 = SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDto1, HttpStatus.OK);
    }

    // check
    // http://localhost:5002/api/salon/search?city=mumbai
    @GetMapping("/search")
    public ResponseEntity<List<SalonDto>> searchSalon(
            @RequestParam("city") String city
    ) throws Exception {
        List<Salon> salons = salonService.searchSalonByCity(city);

        List<SalonDto> salonDtoList = salons.stream().map((salon) ->
                {
                    SalonDto salonDto = SalonMapper.mapToDTO(salon);
                    return  salonDto;
                }
        ).toList();
        return new ResponseEntity<>(salonDtoList, HttpStatus.OK);
    }

    // http://localhost:5002/api/salon/owner
    @GetMapping("/owner")
    public ResponseEntity<SalonDto> getSalonByOwnerId(@PathVariable Long ownerId)
            throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        Salon salon = salonService.getSalonByOwnerId(userDto.getId());
        SalonDto salonDto1 = SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDto1, HttpStatus.OK);
    }
}
