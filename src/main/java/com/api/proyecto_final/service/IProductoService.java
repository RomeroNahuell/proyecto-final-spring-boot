package com.api.proyecto_final.service;


import com.api.proyecto_final.model.Producto;


import java.util.List;

public interface IProductoService {

    //=========== METODOS GET ===========

    //metodo para obtener todo los productos
    public List<Producto> getProductos();

    //metodo para buscar un producto
    public Producto findProducto (Long codigo_producto);

    //metodo para traer los productos con stock menor a 5
    public List<Producto> getProductosStock ();


    //========= METODOS POST =======
    //metodo para crear un producto
    public Producto saveProducto(Producto producto);


    //========= METODOS DELETE =======
    //metodo para eliminar un producto
    public void deleteProducto(Long codigo_producto);




    //========= METODOS PUT =======
    //metodo para editar un producto
    public Producto editProducto ( Producto producto);
}
