package com.test.dettd04.repository;

import com.test.dettd04.entity.CodigoPostal;
import com.test.dettd04.entity.Colonia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColoniaRepository extends JpaRepository<Colonia, String> {

}
