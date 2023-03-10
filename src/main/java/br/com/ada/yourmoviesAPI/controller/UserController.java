package br.com.ada.yourmoviesAPI.controller;

import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.exceptions.UserExistException;
import br.com.ada.yourmoviesAPI.mapper.UserMapper;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.response.UserResponse;
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
    @Autowired
    private UserMapper mapper;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody  UserRequest user) throws UserExistException {

        return new ResponseEntity<>(userService.saveUser(mapper.UserRequestToUserDTO(user)), HttpStatus.CREATED); //TODO Ver isso do UserDTO ou UserEntity
    }

    @GetMapping("/all")
    public List<UserResponse> findAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById (@PathVariable ("id") Long id) throws IdNotFoundException {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
    }



}
