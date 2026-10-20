package com.example.proyecto10.dao;

import com.example.proyecto10.model.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * Implementación del DAO apoyada en ProductoRepository (Spring Data JPA).
 */
@Repository
public class ProductoDaoImpl implements ProductoDao {

    private final ProductoRepository repository;

    public ProductoDaoImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }
}
