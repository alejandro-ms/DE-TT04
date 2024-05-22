package com.test.dettd04.repository;

import com.test.dettd04.entity.CodigoPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, String> {

    CodigoPostal findByCp(@Param("cp") String cp);
    @Query("SELECT cp FROM CodigoPostal cp JOIN cp.colonias c " +
            "WHERE cp.cp = :cp AND cp.estado.clave = :estadoId " +
            "AND (:municipioId is null or cp.municipio.id.clave = :municipioId) AND (:localidadId is null or cp.localidad.id.clave = :localidadId) " +
            "AND (:coloniaId is null or c.id.clave = :coloniaId)")
    Optional<CodigoPostal> findByCpAndDetails(String cp, String estadoId, String municipioId, String localidadId, String coloniaId);

}
