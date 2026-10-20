package com.example.proyecto10.service.impl;

import com.example.proyecto10.dao.ProductoDao;
import com.example.proyecto10.model.Producto;
import com.example.proyecto10.service.ProductoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoDao dao;

    public ProductoServiceImpl(ProductoDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Producto> listar() {
        return dao.listar();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return dao.buscarPorId(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Producto con id " + id + " no encontrado"));
    }

    @Override
    public Producto guardar(Producto producto) {
        if (producto.getPrecio() < 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        return dao.guardar(producto);
    }
}
