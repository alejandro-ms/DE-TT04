package com.test.dettd04.service;

import java.util.Map;

public interface CodigoPostalService {
    Map<String, Object> getDatosPorCodigoPostal(String cp) throws Exception;
}
