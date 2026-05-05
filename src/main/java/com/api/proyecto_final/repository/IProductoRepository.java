package com.api.proyecto_final.repository;

import com.api.proyecto_final.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
}
