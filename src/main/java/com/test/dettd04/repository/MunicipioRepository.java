package com.test.dettd04.repository;

import com.test.dettd04.entity.Estado;
import com.test.dettd04.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, String> {
    List<Municipio> findByEstado(Estado estado);
}
