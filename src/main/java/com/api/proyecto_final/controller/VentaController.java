package com.api.proyecto_final.controller;


import com.api.proyecto_final.dto.VentaDelDiaDTO;
import com.api.proyecto_final.dto.VentaMayorDTO;
import com.api.proyecto_final.model.Producto;
import com.api.proyecto_final.model.Venta;
import com.api.proyecto_final.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    IVentaService ventaServ;

    //metodos CRUD standar

    @GetMapping
    public List<Venta> getVentas(){

        return ventaServ.getVentas();
    }

    @GetMapping("/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaServ.findVenta(codigo_venta);
    }

    @PostMapping("/crear")
    public Venta saveVenta(@RequestBody Venta vent){
        return ventaServ.saveVenta(vent);
    }

    @PutMapping("/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        venta.setCodigo_venta(codigo_venta);
        return ventaServ.saveVenta(venta);
    }


    @DeleteMapping("/eliminar/{codigo_venta}")
    public void deleteVenta(@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
    }

    //metodos especiales

    @GetMapping("/productos/{codigo_venta}")
    public List<Producto> productosDeLaVenta(@PathVariable Long codigo_venta){
        return ventaServ.productosDeLaVenta(codigo_venta);
    }

    @GetMapping("/fecha/{fecha_venta}")
    public VentaDelDiaDTO montoTotalDelDia(@PathVariable LocalDate fecha_venta){
        return ventaServ.montoTotalDelDia(fecha_venta);
    }

    @GetMapping("/mayor_venta")
    public VentaMayorDTO ventaMayor(){
        return ventaServ.ventaMayor();
    }

}
