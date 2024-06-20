package com.codigo.msregistro.domain.impl;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestPersona;
import com.codigo.msregistro.domain.ports.in.PersonaServiceIn;
import com.codigo.msregistro.domain.ports.out.PersonaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaServiceIn { //Damos valor a nuestro contrato IN

    private final PersonaServiceOut personaServiceOut; //Inyectamos a nuestro OUT, es quien devovlera lo que infraestructura realice, o encuentre.
    @Override
    public PersonaDTO crearPersonaIn(RequestPersona persona) {
        //Retornamos los que el Out tiene
        return personaServiceOut.crearPersonaOut(persona);
    }
}
