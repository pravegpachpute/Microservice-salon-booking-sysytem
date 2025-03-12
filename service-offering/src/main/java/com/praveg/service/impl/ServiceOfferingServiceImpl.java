package com.praveg.service.impl;

import com.praveg.dto.CategoryDTO;
import com.praveg.dto.SalonDTO;
import com.praveg.dto.ServiceDTO;
import com.praveg.entity.ServiceOffering;
import com.praveg.repository.ServiceOfferingRepository;
import com.praveg.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(SalonDTO salonDTO,
                                         CategoryDTO categoryDTO,
                                         ServiceDTO serviceDTO) {
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setSalonId(salonDTO.getId());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setDuration(serviceDTO.getDuration());
        serviceOffering.setCategoryId(categoryDTO.getId());
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingRepository
                .findById(serviceId).orElse(null);

        if (serviceOffering == null){
            throw new Exception("Service not exist with id - " +serviceId);
        }
        serviceOffering.setName(service.getName());
        serviceOffering.setImage(service.getImage());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setDuration(service.getDuration());
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId) {
        Set<ServiceOffering> services = serviceOfferingRepository.findBySalonId(salonId);

        // filter category data
        if (categoryId != null){
            services = services.stream().filter((service) ->
                    service.getCategoryId() != null && service.getCategoryId() == categoryId)
                    .collect(Collectors.toSet());
        }
        return services;
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> services = serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(id).orElse(null);
        if (serviceOffering == null){
            throw new Exception("Service not exist id - " +id);
        }
        return serviceOffering;
    }
}
