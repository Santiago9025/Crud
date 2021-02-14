package com.ejercicio.aws.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.aws.modelo.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
