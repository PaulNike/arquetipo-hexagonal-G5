package com.codigo.msregistro.infraestructure.dao;

import com.codigo.msregistro.infraestructure.entity.PersonaEntity;
import org.springframework.data.repository.CrudRepository;

public interface Persona2 extends CrudRepository<PersonaEntity,Long> {
}
