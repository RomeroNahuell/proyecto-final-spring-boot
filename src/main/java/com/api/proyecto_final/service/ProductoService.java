package com.api.proyecto_final.service;

import com.api.proyecto_final.exception.NotFoundException;
import com.api.proyecto_final.model.Producto;
import com.api.proyecto_final.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    IProductoRepository produRepo;


    @Override
    public List<Producto> getProductos() {
        List<Producto> listProductos = produRepo.findAll();
        return listProductos;
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        Producto produEncontrado = produRepo.findById(codigo_producto).orElse(null);
        if (produEncontrado == null){
            throw new NotFoundException("No se encontro el producto");
        }

        return produEncontrado;
    }

    @Override
    public List<Producto> getProductosStock() {
        List<Producto> productosConMenorStock = new ArrayList<>();
        for (Producto produ:this.getProductos()){
            if (produ.getCantidad_disponible() < 5){
                productosConMenorStock.add(produ);
            }
        }
        return productosConMenorStock;
    }

    @Override
    public Producto saveProducto(Producto producto) {
        Producto produCreado = produRepo.save(producto);
        return produCreado;
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
       produRepo.deleteById(codigo_producto);
    }

    @Override
    public Producto editProducto(Producto producto) {
        Producto produNuevo = produRepo.save(producto);
        return produNuevo;
    }
}
