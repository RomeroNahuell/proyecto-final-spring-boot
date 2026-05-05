package com.api.proyecto_final.repository;

import com.api.proyecto_final.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
    public List<Venta> findByFechaVenta(LocalDate fechaVenta);
}

