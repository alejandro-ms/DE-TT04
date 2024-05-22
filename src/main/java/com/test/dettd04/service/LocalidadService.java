package com.test.dettd04.service;

import com.test.dettd04.entity.Estado;
import com.test.dettd04.entity.Localidad;

import java.util.List;

public interface LocalidadService {
    List<Localidad> findByEstado(String estado);
}
