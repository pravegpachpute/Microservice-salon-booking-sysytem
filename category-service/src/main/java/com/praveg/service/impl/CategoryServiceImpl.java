package com.praveg.service.impl;

import com.praveg.dto.SalonDto;
import com.praveg.entity.Category;
import com.praveg.repository.CategoryRepository;
import com.praveg.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category saveCategory(Category category, SalonDto salonDto) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setImage(category.getImage());
        newCategory.setSalonId(salonDto.getId());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
      Category category = categoryRepository.findById(id).orElse(null);
      if (category == null){
          throw new Exception("Category not found with id -" +id);
      }
        return category;
    }

    @Override
    public void deleteCategorybyId(Long id, Long salonId) throws Exception {
       Category category = getCategoryById(id);
       if (!category.getSalonId().equals(salonId)){     // user can delete only his category
           throw new Exception("You have don't permission to delete this category");
       }
        categoryRepository.deleteById(id);
    }
}
