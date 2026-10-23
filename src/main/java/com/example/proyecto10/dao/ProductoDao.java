package com.example.proyecto10.dao;

import com.example.proyecto10.model.Producto;
import java.util.List;
import java.util.Optional;


public interface ProductoDao {

    List<Producto> listar();

    Optional<Producto> buscarPorId(Long id);

    Producto guardar(Producto producto);
}
