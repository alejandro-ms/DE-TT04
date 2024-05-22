package com.test.dettd04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "municipio")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Municipio {

    @EmbeddedId
    private MunicipioId id;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore
    @MapsId("estado")
    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "clave", insertable = false, updatable = false)
    private Estado estado;
}