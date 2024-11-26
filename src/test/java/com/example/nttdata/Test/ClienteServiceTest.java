package com.example.nttdata.Test;

import com.example.nttdata.Services.ServiceCliente;
import org.junit.jupiter.api.Test;
import com.example.nttdata.Model.Cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ClienteServiceTest {
    @Test
    void testObtenerClienteporDoc(){
        ServiceCliente serviceCliente = new ServiceCliente();
        Cliente cliente = serviceCliente.obtenerClienteporDoc("C","123456");
        assertEquals("Jose",cliente.getPrimerNombre());
        assertEquals("Luis",cliente.getSegundoNombre());
        assertEquals("Perez",cliente.getPrimerApeliido());
        assertEquals("González", cliente.getSegundoApellido());
        assertEquals("123456789", cliente.getTelefono());
        assertEquals("Calle Falsa 123", cliente.getDireccion());
        assertEquals("Bogotá", cliente.getCiudadResidencia());
    }
}
