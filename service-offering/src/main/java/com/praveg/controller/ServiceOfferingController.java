package com.praveg.controller;

import com.praveg.entity.ServiceOffering;
import com.praveg.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    // check
    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServicesBySalonId(
            @PathVariable Long salonId,
            @RequestParam(required = false) Long categoryId
    ){
        Set<ServiceOffering> serviceOfferings = serviceOfferingService
                .getAllServiceBySalonId(salonId, categoryId);
        return ResponseEntity.ok(serviceOfferings);
    }

    // check
    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceById(
            @PathVariable Long id
    ) throws Exception {
        ServiceOffering serviceOfferings = serviceOfferingService
                .getServiceById(id);
        return ResponseEntity.ok(serviceOfferings);
    }

    // check
    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServicesBySalonId(
            @PathVariable Set<Long> ids
    ){
        Set<ServiceOffering> serviceOfferings = serviceOfferingService
                .getServicesByIds(ids);
        return ResponseEntity.ok(serviceOfferings);
    }
}
