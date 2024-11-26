package com.example.nttdata.Controllers;

import com.example.nttdata.Model.Cliente;
import com.example.nttdata.Services.ServiceCliente;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
@Validated
public class ClienteController {
private  final ServiceCliente serviceCliente;

    public ClienteController(ServiceCliente serviceCliente) {
        this.serviceCliente = serviceCliente;
    }
    @GetMapping
    public String prueba(){
        return "Conexion ok";
    }
    @GetMapping("DatosClient")
    public ResponseEntity<?> obtenerClient(
            @Parameter(description = "Tipo de documento: 'C' (Cédula) o 'P' (Pasaporte)", required = true)
            @RequestParam(required = true) String tipoDocumento,
            @Parameter(description = "Número de documento del cliente", required = true)
            @RequestParam(required = true) String numeroDocumento
    ){
        if ( tipoDocumento == null || numeroDocumento == null){
            return ResponseEntity.badRequest().body(
                    "Los dos campos son obligatorios tipo Doc y Numero Doc"
            );
        }
        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")){
            return ResponseEntity.badRequest().body(
                    "Tipo de Documento no válido. Solo se permite 'C' (Cedula de Ciudadania) o 'P' (Pasaporte)"
            );
        }
        Cliente cliente = serviceCliente.obtenerClienteporDoc(tipoDocumento, numeroDocumento);
        return ResponseEntity.ok(cliente);
   }
}
