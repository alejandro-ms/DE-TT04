package com.test.dettd04.service.impl;

import com.test.dettd04.entity.DireccionDTO;
import com.test.dettd04.repository.CodigoPostalRepository;
import com.test.dettd04.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private CodigoPostalRepository codigoPostalRepository;
    @Override
    public boolean validarDireccion(DireccionDTO direccionDTO) {
        return codigoPostalRepository.findByCpAndDetails(direccionDTO.getCp(), direccionDTO.getEstadoId(), direccionDTO.getMunicipioId(), direccionDTO.getLocalidadId(), direccionDTO.getColoniaId()).isPresent();
    }
}
