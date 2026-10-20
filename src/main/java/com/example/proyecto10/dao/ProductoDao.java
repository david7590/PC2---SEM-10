package com.example.proyecto10.dao;

import com.example.proyecto10.model.Producto;
import java.util.List;
import java.util.Optional;

/**
 * Patrón DAO: contrato de acceso a datos para Producto.
 * La capa de servicio depende de esta interfaz, no de SQL ni de JPA.
 */
public interface ProductoDao {

    List<Producto> listar();

    Optional<Producto> buscarPorId(Long id);

    Producto guardar(Producto producto);
}
