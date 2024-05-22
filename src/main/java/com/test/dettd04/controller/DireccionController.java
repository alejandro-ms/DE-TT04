package com.test.dettd04.controller;

import com.test.dettd04.entity.*;
import com.test.dettd04.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DireccionController {

    @Autowired
    private EstadoService estadoService;
    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private LocalidadService localidadService;

    @Autowired
    private CodigoPostalService codigoPostalService;

    @Autowired
    private DireccionService direccionService;

    @GetMapping("/estados")
    public List<Estado> getAllEstados() {
        return estadoService.findAll();
    }

   @GetMapping("/municipios/{estadoId}")
    public List<Municipio> getMunicipiosByEstado(@PathVariable String estadoId) {
        return municipioService.findByEstado(estadoId);
    }

    @GetMapping("/localidades/{estadoId}")
    public List<Localidad> getMLocalidadesByEstado(@PathVariable String estadoId) {
        return localidadService.findByEstado(estadoId);
    }


    @GetMapping("/codigo-postal/{cp}")
    @ResponseBody
    public Map<String, Object> getDatosPorCodigoPostal(@PathVariable String cp) throws Exception {
        return codigoPostalService.getDatosPorCodigoPostal(cp);
    }

    @PostMapping("/validar-direccion")
    public ResponseEntity<?> validarDireccion(@RequestBody DireccionDTO direccionDTO) {
        boolean esValido = direccionService.validarDireccion(direccionDTO);
        if (esValido) {
            return ResponseEntity.ok("Los datos ingresados son válidos.");
        } else {
            return ResponseEntity.badRequest().body("Datos inconsistentes con los catálogos proporcionados.");
        }
    }

}

