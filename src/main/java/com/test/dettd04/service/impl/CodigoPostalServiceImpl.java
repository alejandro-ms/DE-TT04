package com.test.dettd04.service.impl;

import com.test.dettd04.entity.*;
import com.test.dettd04.exception.CodigoPostalNotFoundException;
import com.test.dettd04.repository.CodigoPostalRepository;
import com.test.dettd04.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoPostalServiceImpl implements CodigoPostalService {

    @Autowired
    CodigoPostalRepository codigoPostalRepository;
    @Override
    public Map<String, Object> getDatosPorCodigoPostal(String cp) throws Exception {
        Map<String, Object> response = new HashMap<>();
        CodigoPostal codigoPostal = codigoPostalRepository.findByCp(cp);

        if (codigoPostal != null) {
            response.put("estado", codigoPostal.getEstado());
            response.put("municipio", getMunicipio(codigoPostal));
            response.put("localidad", getLocalidad(codigoPostal));
            response.put("colonias", codigoPostal.getColonias() != null ? codigoPostal.getColonias() : new ArrayList<>());
        } else {
            throw new CodigoPostalNotFoundException("Código postal no encontrado");
        }

        return response;
    }

    private Municipio getMunicipio(CodigoPostal codigoPostal) {
        Municipio municipio = new Municipio();
        if(codigoPostal.getMunicipio() != null) {
            municipio.setId(codigoPostal.getMunicipio().getId());
            municipio.setDescripcion(codigoPostal.getMunicipio().getDescripcion());
        }
        return municipio;
    }

    private Localidad getLocalidad(CodigoPostal codigoPostal) {
        Localidad localidad = new Localidad();
        if(codigoPostal.getLocalidad() != null) {
            localidad.setId(codigoPostal.getLocalidad().getId());
            localidad.setDescripcion(codigoPostal.getLocalidad().getDescripcion());
        }
        return localidad;
    }
}
