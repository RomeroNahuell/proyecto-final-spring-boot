package com.api.proyecto_final.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;

    private LocalDate fecha_venta;
    private double total;


    //relacion con producto
    @OneToMany
    @JoinColumn(name = "codigo_venta")
    private List<Producto> listaProductos;

    //relacion con cliente
    @OneToOne
    @JoinColumn(name = "id_cliente",
            referencedColumnName = "id_cliente")
    private Cliente cliente;

}
