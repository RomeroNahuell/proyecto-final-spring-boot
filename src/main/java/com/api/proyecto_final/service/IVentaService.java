package com.api.proyecto_final.service;

import com.api.proyecto_final.dto.VentaDelDiaDTO;
import com.api.proyecto_final.dto.VentaMayorDTO;
import com.api.proyecto_final.model.Producto;
import com.api.proyecto_final.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    //metodo para obtener todas las ventas
    public List<Venta> getVentas();

    //metodo para buscar una venta
    public Venta findVenta (Long codigo_venta);

    //metodo para obtener los productos de la venta
    public List<Producto> productosDeLaVenta(Long codigo_venta);

    //metodo para obtener el monto total y cantidad de ventas de un determinado dia
    public VentaDelDiaDTO montoTotalDelDia(LocalDate fecha);

    //metodo para obtener la venta mayor
    public VentaMayorDTO ventaMayor();

    //metodo para crear una venta
    public Venta saveVenta(Venta venta);

    //metodo para eliminar una venta
    public void deleteVenta(Long codigo_venta);

    //metodo para modificar una venta
    public Venta editVenta(Long codigo_venta, Venta venta);
}

