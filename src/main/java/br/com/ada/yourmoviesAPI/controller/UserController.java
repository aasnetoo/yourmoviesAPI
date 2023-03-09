package br.com.ada.yourmoviesAPI.controller;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserRequest user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserEntity> findAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable ("id") Long id) throws IdNotFoundException {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.CREATED);
    }



}
