package com.praveg.service;

import com.praveg.dto.CategoryDTO;
import com.praveg.dto.SalonDTO;
import com.praveg.dto.ServiceDTO;
import com.praveg.entity.ServiceOffering;

import java.util.List;
import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDTO salonDTO,
                                  CategoryDTO categoryDTO,
                                  ServiceDTO serviceDTO);

    ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;

    // filter types of category
    Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId);

    Set<ServiceOffering> getServicesByIds(Set<Long>ids);

    ServiceOffering getServiceById(Long id) throws Exception;
}
