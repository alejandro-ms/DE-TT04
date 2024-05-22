package com.test.dettd04.entity;


import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class LocalidadId implements Serializable {
    private String clave;

    @Column(name = "estado", insertable = false, updatable = false)
    private String estado;
}
