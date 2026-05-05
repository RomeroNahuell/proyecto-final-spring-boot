package com.api.proyecto_final.service;

import com.api.proyecto_final.exception.NotFoundException;
import com.api.proyecto_final.model.Cliente;
import com.api.proyecto_final.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository clieRepo;


    @Override
    public List<Cliente> getCliente() {
        List<Cliente> listaDeClientes = clieRepo.findAll();
        return listaDeClientes;
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
       Cliente clie = clieRepo.findById(id_cliente).orElse(null);
       if (clie == null){
           throw new NotFoundException("Cliente no encontrado");
       }
       return clie;
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        Cliente clieCreado = clieRepo.save(cliente);
        return clieCreado;
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clieRepo.deleteById(id_cliente);
    }

    @Override
    public Cliente editCliente( Cliente cliente) {
        Cliente clieEditado = clieRepo.save(cliente);
        return clieEditado;
    }
}
