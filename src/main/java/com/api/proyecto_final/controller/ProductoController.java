package com.api.proyecto_final.controller;

import com.api.proyecto_final.model.Producto;
import com.api.proyecto_final.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    IProductoService producServ;

    @PostMapping("/crear")
    public Producto saveProducto(@RequestBody Producto producto){
        return producServ.saveProducto(producto);
    }

    @GetMapping
    public List<Producto> getProductos(){
        return producServ.getProductos();
    }

    @GetMapping("/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return producServ.findProducto(codigo_producto);
    }

    @DeleteMapping("/eliminar/{codigo_producto}")
    public void deleteProducto(@PathVariable Long codigo_producto){
        producServ.deleteProducto(codigo_producto);
    }

    @PutMapping("/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,@RequestBody Producto producto){
        producto.setCodigo_producto(codigo_producto);
        return producServ.editProducto(producto);
    }

    @GetMapping("/falta_stock")
    public List<Producto> getProductosConBajoStock(){
        return producServ.getProductosStock();
    }





}
