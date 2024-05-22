package com.test.dettd04.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "codigo_postal")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cp")
public class CodigoPostal {
    @Id
    private String cp;

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "clave", insertable = false, updatable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "municipio", referencedColumnName = "clave", insertable = false, updatable = false),
            @JoinColumn(name = "estado", referencedColumnName = "estado", insertable = false, updatable = false)
    })
    private Municipio municipio;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "localidad", referencedColumnName = "clave", insertable = false, updatable = false),
            @JoinColumn(name = "estado", referencedColumnName = "estado", insertable = false, updatable = false)
    })
    private Localidad localidad;

    @OneToMany(mappedBy = "codigoPostal")
    @JsonManagedReference
    private List<Colonia> colonias;
}