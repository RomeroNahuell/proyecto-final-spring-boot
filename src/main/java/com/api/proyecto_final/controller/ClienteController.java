package com.api.proyecto_final.controller;

import com.api.proyecto_final.model.Cliente;
import com.api.proyecto_final.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    IClienteService clieServ;

    @GetMapping
    public List<Cliente> getClientes(){
        return clieServ.getCliente();
    }

    @GetMapping("/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clieServ.findCliente(id_cliente);
    }

    @PostMapping("/crear")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clieServ.saveCliente(cliente);
    }


    @DeleteMapping("/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente){
        clieServ.deleteCliente(id_cliente);
    }

    @PutMapping("/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente, @RequestBody Cliente client){
        client.setId_cliente(id_cliente);
        return clieServ.saveCliente(client);

    }

}
