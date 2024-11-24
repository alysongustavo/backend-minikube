package br.com.alysonrodrigo.backend_minikube.domain.repository;

import br.com.alysonrodrigo.backend_minikube.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
