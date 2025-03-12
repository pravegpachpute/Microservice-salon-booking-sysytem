package com.praveg.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ServiceDTO {

    private Long id;
    private String name;
    private String description;
    private int price;
    private int duration;       // kiti vel laghel 1 haircut la ex - 30 minutes
    private Long salonId;
    private Long category;
    private String image;
}
