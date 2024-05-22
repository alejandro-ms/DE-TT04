package com.test.dettd04.service.impl;

import com.test.dettd04.entity.Estado;
import com.test.dettd04.repository.EstadoRepository;
import com.test.dettd04.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll();

    }


}