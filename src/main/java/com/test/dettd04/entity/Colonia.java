package com.test.dettd04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "colonia")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Colonia {
    @EmbeddedId
    private ColoniaId id;

    private String descripcion;

    @ManyToOne
    @MapsId("cp")
    @JoinColumn(name = "cp", referencedColumnName = "cp", insertable = false, updatable = false)
    @JsonBackReference
    private CodigoPostal codigoPostal;
}