package com.test.dettd04.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class MunicipioId implements Serializable {
    private String clave;
    private String estado;
}
