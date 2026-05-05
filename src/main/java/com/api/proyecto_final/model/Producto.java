package com.api.proyecto_final.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Producto {

    //clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;

    //atributos
    private String nombre;
    private String marca;
    private double  costo;
    private double cantidad_disponible;


    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, double costo, double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
}
