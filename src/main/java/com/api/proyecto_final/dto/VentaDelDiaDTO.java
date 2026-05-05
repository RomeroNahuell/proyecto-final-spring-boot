package com.api.proyecto_final.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaDelDiaDTO {

    private double montoTotal;
    private int ventasDelDia;

    public VentaDelDiaDTO() {
    }

    public VentaDelDiaDTO(double montoTotal, int ventasDelDia) {
        this.montoTotal = montoTotal;
        this.ventasDelDia = ventasDelDia;
    }
}
