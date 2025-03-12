package com.praveg.controller;

import com.praveg.dto.SalonDto;
import com.praveg.entity.Category;
import com.praveg.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category/salon-owner")
public class OwnerCategoryController {

    private final CategoryService categoryService;

    // check
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        SalonDto salonDto = new SalonDto();
        salonDto.setId(1L);
        Category createCategory = categoryService.saveCategory(category, salonDto);
        return ResponseEntity.ok(createCategory);
    }

    // check
    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) throws Exception {
        SalonDto salonDto = new SalonDto();
        salonDto.setId(1L);
        categoryService.deleteCategorybyId(id, salonDto.getId());
        return ResponseEntity.ok("Category deleted successfully...");
    }
}
