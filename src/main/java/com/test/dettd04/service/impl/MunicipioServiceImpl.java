package com.test.dettd04.service.impl;

import com.test.dettd04.entity.Estado;
import com.test.dettd04.entity.Municipio;
import com.test.dettd04.repository.MunicipioRepository;
import com.test.dettd04.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioServiceImpl implements MunicipioService {
    @Autowired
    MunicipioRepository municipioRepository;
    @Override
    public List<Municipio> findByEstado(String clave) {
        Estado estado = new Estado();
        estado.setClave(clave);
        return municipioRepository.findByEstado(estado);
    }
}
