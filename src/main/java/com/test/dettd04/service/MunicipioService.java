package com.test.dettd04.service;

import com.test.dettd04.entity.Municipio;

import java.util.List;

public interface MunicipioService {
    List<Municipio> findByEstado(String estado);
}
