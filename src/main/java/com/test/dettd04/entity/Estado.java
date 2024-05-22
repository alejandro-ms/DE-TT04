package com.test.dettd04.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "estado")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "clave")
public class Estado {
    @Id
    private String clave;

    private String pais;

    private String nombreEstado;

    @OneToMany(mappedBy = "estado")
    private List<Municipio> municipios;

    @OneToMany(mappedBy = "estado")
    private List<Localidad> localidades;
}