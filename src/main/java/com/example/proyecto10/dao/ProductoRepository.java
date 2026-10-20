package com.example.proyecto10.dao;

import com.example.proyecto10.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data genera la implementación CRUD (findAll, findById, save, deleteById...).
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
