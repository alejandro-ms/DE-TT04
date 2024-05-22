package com.test.dettd04.service.impl;

import com.test.dettd04.entity.Estado;
import com.test.dettd04.entity.Localidad;
import com.test.dettd04.repository.LocalidadRepository;
import com.test.dettd04.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl implements LocalidadService {

    @Autowired
    LocalidadRepository localidadRepository;


    @Override
    public List<Localidad> findByEstado(String clave) {
        Estado estado = new Estado();
        estado.setClave(clave);
        return localidadRepository.findByEstado(estado);
    }
}
