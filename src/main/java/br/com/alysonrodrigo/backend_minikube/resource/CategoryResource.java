package br.com.alysonrodrigo.backend_minikube.resource;

import br.com.alysonrodrigo.backend_minikube.domain.model.Category;
import br.com.alysonrodrigo.backend_minikube.domain.service.CategoryService;
import br.com.alysonrodrigo.backend_minikube.dto.CategoryDTO;
import br.com.alysonrodrigo.backend_minikube.mapper.CategoryMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "${spring.web.cors.allowed-origins}")
public class CategoryResource {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryResource(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.categoryService.findAll();
         return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        Category category = this.categoryService.findById(id);
        CategoryDTO categoryDTO = this.categoryMapper.toDto(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {

        Category category1 = this.categoryMapper.toEntity(categoryDTO);
        this.categoryService.save(category1);
        CategoryDTO categoryDTOInsert = this.categoryMapper.toDto(category1);
        return ResponseEntity.ok(categoryDTOInsert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        Category category1 = this.categoryMapper.toEntity(categoryDTO);
        this.categoryService.update(category1, id);
        CategoryDTO category = this.categoryMapper.toDto(category1);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
