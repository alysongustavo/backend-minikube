package br.com.alysonrodrigo.backend_minikube.domain.service;

import br.com.alysonrodrigo.backend_minikube.domain.model.Category;
import br.com.alysonrodrigo.backend_minikube.domain.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }

    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    public void update(Category category, Long id) {
        Category category1 = this.categoryRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(category, category1, "id");
        this.categoryRepository.save(category1);
    }

    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
