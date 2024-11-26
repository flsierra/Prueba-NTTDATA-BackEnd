package com.example.nttdata.Services;

import com.example.nttdata.Model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ServiceCliente {
    public Cliente obtenerClienteporDoc(String tipoDocumento, String numeroDocumento){
        return new Cliente(
                "Jose",
                "Luis",
                "Perez",
                "González",
                "123456789",
                "Calle Falsa 123",
                "Bogotá"
        );

    }

}
