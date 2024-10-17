package com.crud.crud.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.models.User;
import com.crud.crud.services.UserService;



@RestController
@RequestMapping("/api")
public class UserController {

    //Variable que permite el consumo a los metodos que hacen operaciones en la BD
    private final UserService userService;

    //Se inicializa la variable por inyección de dependencias
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //Metodo get que obtiene la lista de usuarios desde el servicio expuesto
    @GetMapping("/users")
    public List<User> users(){
        return userService.findAll();
    }
    
    //Metodo que permite crear un usuario
    @PostMapping("/create")
    //El metodo es de tipo response Entity ya que permite tener un mayor control en las respuestas de la petición
    public ResponseEntity<User> createUser(@RequestBody User user) {
        //Variable  que obtiene el usuario insertado
        User newUser = userService.save(user);
        //Se retorna el nuevo usuario con un codigo 200
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    //Metodo para editar 
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        //Se mapea el id del usuario a editar ya que el metodo save hace la creación y modificación
        //Se ejecuta modificar cuando el id viene con valores, cuando es null hace un nuevo registro
        user.setId(id);
        //Se retorna el objeto modificado con un codigo 200
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
    //Controlador que permite eliminar usuarios por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        //Se crea una nueva instancia de usuario para poder setear el id del usuario a eliminar
        User user = new User();
        user.setId(id);
        //Se obtiene el usuario de la BD en una clase Optional ya que nos permite manejar de mejor manera los valores null
        Optional<User> userDb = userService.findById(id);
        //Se verifica si hay un usuario en la consulta y si existe lo elimina y retorna el usuario eliminado
        if(userDb.isPresent()){
            userDb = userService.delete(user);
            return ResponseEntity.ok(userDb.orElseThrow());
        }

        Map<String,Object> error = new HashMap<>();
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("message", "Error al eliminar el usuario");
        error.put("Date", LocalDateTime.now());
        //Si no existe responde el map con el error 
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
