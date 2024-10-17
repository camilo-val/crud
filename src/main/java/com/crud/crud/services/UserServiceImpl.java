package com.crud.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.crud.models.User;
import com.crud.crud.repositories.UserRepository;

//Expone el servicio como un componente y permite inyectar en otros componentes spring
//Se realiza la programación orientada a interfaces
@Service
public class UserServiceImpl implements UserService {

    //Inyectamos el repositorio de consultas de la bd
    @Autowired
    private UserRepository userRepository;
    //Esta etiqueta con esta propiedad indica que la operación que se realiza es de solo lectura
    //Metodo para obetener un listado de usuarios
    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
    //Metodo para obtener un usuario por id
    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    //Metodo para crear o modificar un usuario
    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    //Metodo para eliminar un usuario
    @Transactional
    @Override
    public Optional<User> delete(User user) {
        //Se busca el usuario a eliminar en la BD
        Optional<User> userDelete = userRepository.findById(user.getId());
        //Se evalua si el usuario existe de ser aí ejecuta el delete
        userDelete.ifPresent(userDb ->{
            userRepository.delete(userDb);
        });
        return userDelete;
    }
}
