package br.com.alysonrodrigo.backend_minikube.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @SequenceGenerator(name = "seq_category", sequenceName = "seq_category", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    private Long id;
    private String name;
}
