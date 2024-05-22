package com.test.dettd04.repository;

import com.test.dettd04.entity.Estado;
import com.test.dettd04.entity.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, String> {
    List<Localidad> findByEstado(Estado estado);
}
