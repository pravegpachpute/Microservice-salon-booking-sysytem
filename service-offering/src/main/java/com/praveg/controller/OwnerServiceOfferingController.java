package com.praveg.controller;

import com.praveg.dto.CategoryDTO;
import com.praveg.dto.SalonDTO;
import com.praveg.dto.ServiceDTO;
import com.praveg.entity.ServiceOffering;
import com.praveg.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class OwnerServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    // check
    @PostMapping("/create")
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO
    ){
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceOfferings = serviceOfferingService
                .createService(salonDTO, categoryDTO, serviceDTO);
        return ResponseEntity.ok(serviceOfferings);
    }

    // check
    @PatchMapping("/{id}")
    public ResponseEntity<ServiceOffering> createService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering
    ) throws Exception {
        ServiceOffering serviceOfferings = serviceOfferingService
                .updateService(id, serviceOffering);
        return ResponseEntity.ok(serviceOfferings);
    }
}
