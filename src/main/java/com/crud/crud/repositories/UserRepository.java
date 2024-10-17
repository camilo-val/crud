package com.crud.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crud.crud.models.User;;

//Se implementa la interface Crud repository que ejcuta toda las operaciones a la bd, esta clase es de Springbot y tiene metodos para crear, eliminar, seleccionar, etc..
public interface  UserRepository extends CrudRepository<User,Long>{

}
