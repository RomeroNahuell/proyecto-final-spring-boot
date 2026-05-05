package com.api.proyecto_final.dto;

import com.api.proyecto_final.model.Cliente;
import com.api.proyecto_final.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VentaMayorDTO {

    private Long codigo_venta;
    private double total;
    private int cantidadProductos;
    private String nombre_cliente;
    private String apellido_cliente;


}

