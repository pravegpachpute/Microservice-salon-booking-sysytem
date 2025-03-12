package com.praveg.service;

import com.praveg.dto.SalonDto;
import com.praveg.entity.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SalonDto salonDto);

    Set<Category> getAllCategoriesBySalon(Long id);

    Category getCategoryById(Long id) throws Exception;

    void deleteCategorybyId(Long id, Long salonId) throws Exception;


}
