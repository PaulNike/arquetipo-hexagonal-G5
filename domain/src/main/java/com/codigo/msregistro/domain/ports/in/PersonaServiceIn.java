package com.codigo.msregistro.domain.ports.in;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestPersona;

public interface PersonaServiceIn {
    PersonaDTO crearPersonaIn(RequestPersona persona);
}
