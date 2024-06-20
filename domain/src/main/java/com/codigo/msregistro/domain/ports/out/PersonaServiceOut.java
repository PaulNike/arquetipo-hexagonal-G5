package com.codigo.msregistro.domain.ports.out;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestPersona;

public interface PersonaServiceOut {
    PersonaDTO crearPersonaOut(RequestPersona persona);
}
