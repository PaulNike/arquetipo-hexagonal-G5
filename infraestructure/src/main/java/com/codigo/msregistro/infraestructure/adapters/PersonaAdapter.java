package com.codigo.msregistro.infraestructure.adapters;

import com.codigo.msregistro.domain.aggregates.constants.Constants;
import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestPersona;
import com.codigo.msregistro.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistro.domain.ports.out.PersonaServiceOut;
import com.codigo.msregistro.infraestructure.dao.PersonaRepository;
import com.codigo.msregistro.infraestructure.entity.PersonaEntity;
import com.codigo.msregistro.infraestructure.mapper.PersonaMapper;
import com.codigo.msregistro.infraestructure.rest.ClienteReniec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class PersonaAdapter implements PersonaServiceOut {

    private final PersonaRepository personaRepository;
    private final ClienteReniec reniec;
    private final PersonaMapper personaMapper;

    @Value("${token}")
    private String token;

    @Override
    public PersonaDTO crearPersonaOut(RequestPersona persona) {
        PersonaEntity personaEntity = getPersonaEntity(persona);
        return personaMapper.mapToDto(personaRepository.save(personaEntity));
    }

    private PersonaEntity getPersonaEntity(RequestPersona requestPersona){
        ResponseReniec responseReniec = getExec(requestPersona.getNumDoc());
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setNumDocu(responseReniec.getNumeroDocumento());
        personaEntity.setNombres(responseReniec.getNombres());
        personaEntity.setApePat(responseReniec.getApellidoPaterno());
        personaEntity.setApeMat(responseReniec.getApellidoMaterno());
        personaEntity.setEstado(Constants.ESTADO_ACTIVO);
        personaEntity.setUsuaCrea(Constants.USU_ADMIN);
        personaEntity.setDateCreate(getTime());
        return personaEntity;

    }

    private Timestamp getTime(){
        long current = System.currentTimeMillis();
        return new Timestamp(current);
    }
    private ResponseReniec getExec(String numero){
        String head = "Bearer "+token;
        ResponseReniec responseReniec = reniec.getInfoReniec(numero,head);
        return responseReniec;
    }
}
