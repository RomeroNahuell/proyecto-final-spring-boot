package com.api.proyecto_final.service;

import com.api.proyecto_final.dto.VentaDelDiaDTO;
import com.api.proyecto_final.dto.VentaMayorDTO;
import com.api.proyecto_final.exception.NotFoundException;
import com.api.proyecto_final.model.Cliente;
import com.api.proyecto_final.model.Producto;
import com.api.proyecto_final.model.Venta;
import com.api.proyecto_final.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    IVentaRepository ventaRepo;

    @Override
    public List<Venta> getVentas() {
        List<Venta> listaClientes = ventaRepo.findAll();
        return listaClientes;
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        Venta ventaEncontrada = ventaRepo.findById(codigo_venta).orElse(null);
        if (ventaEncontrada == null){
            throw new NotFoundException("Venta no encontrada");
        }
        return ventaEncontrada;
    }

    @Override
    public List<Producto> productosDeLaVenta(Long codigo_venta) {
        Venta vent = this.findVenta(codigo_venta);
        List<Producto> listaProductos = vent.getListaProductos();
        return listaProductos;
    }

    @Override
    public VentaDelDiaDTO montoTotalDelDia(LocalDate fecha_venta) {
        VentaDelDiaDTO dto = new VentaDelDiaDTO();
        double montoTotal = 0.0;
        List<Venta> listaDeVenta = ventaRepo.findByFechaVenta(fecha_venta);
        for (Venta vent:listaDeVenta){
            montoTotal = montoTotal + vent.getTotal();
        }
        int ventasDelDia = listaDeVenta.size();

        dto.setMontoTotal(montoTotal);
        dto.setVentasDelDia(ventasDelDia);

        return dto;
    }

    @Override
    public VentaMayorDTO ventaMayor() {
        Venta ventaMayor = null;
        for (Venta vent:this.getVentas()){
            if (ventaMayor == null){
                ventaMayor = vent;
            }
            if(vent.getTotal() > ventaMayor.getTotal()){
                ventaMayor = vent;
            }
        }
        List<Producto> listProductosMayor = ventaMayor.getListaProductos();
        int cantidadProductos = listProductosMayor.size();
        Cliente clie = ventaMayor.getCliente();

        VentaMayorDTO dto = new VentaMayorDTO();

        dto.setCodigo_venta(ventaMayor.getCodigo_venta());
        dto.setTotal(ventaMayor.getTotal());
        dto.setCantidadProductos(cantidadProductos);
        dto.setNombre_cliente(clie.getNombre());
        dto.setApellido_cliente(clie.getApellido());


        return dto;

    }


    @Override
    public Venta saveVenta(Venta venta) {
        Venta ventCreada = ventaRepo.save(venta);
        return ventCreada;
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public Venta editVenta(Long codigo_venta, Venta venta) {
        Venta ventModificada = ventaRepo.save(venta);
        return ventModificada;
    }
}
