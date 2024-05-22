package com.test.dettd04.entity;

import lombok.Data;

@Data
public class DireccionDTO {
    private String cp;
    private String estadoId;
    private String municipioId;
    private String localidadId;
    private String coloniaId;
}
