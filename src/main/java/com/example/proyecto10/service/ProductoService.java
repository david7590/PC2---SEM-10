package com.example.proyecto10.service;

import com.example.proyecto10.model.Producto;
import java.util.List;

/**
 * Capa de lógica de negocio.
 */
public interface ProductoService {

    List<Producto> listar();

    /** Lanza ResponseStatusException 404 si el producto no existe. */
    Producto buscarPorId(Long id);

    /** Lanza IllegalArgumentException si el precio es negativo. */
    Producto guardar(Producto producto);
}
