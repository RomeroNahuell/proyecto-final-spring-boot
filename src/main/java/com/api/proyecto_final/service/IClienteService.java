package com.api.proyecto_final.service;




import com.api.proyecto_final.model.Cliente;

import java.util.List;

public interface IClienteService {

    //metodo para obtener todo los clientes
    public List<Cliente> getCliente();

    //metodo para buscar un cliente
    public Cliente findCliente (Long id_cliente);

    //metodo para crear un cliente
    public Cliente saveCliente(Cliente cliente);

    //metodo para eliminar un cliente
    public void deleteCliente(Long id_cliente);

    //metodo para editar un cliente
    public Cliente editCliente ( Cliente cliente);
}
