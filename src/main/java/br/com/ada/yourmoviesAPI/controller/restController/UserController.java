package br.com.ada.yourmoviesAPI.controller.restController;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.exceptions.UserExistException;
import br.com.ada.yourmoviesAPI.mapper.UserMapper;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.response.UserResponse;
import br.com.ada.yourmoviesAPI.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/yourmovies")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper mapper;

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserRequest user) throws UserExistException {
        return new ResponseEntity<>(userService.saveUser(mapper.UserRequestToUserDTO(user)), HttpStatus.CREATED);
    }

    @GetMapping("/users/all")
    public List<UserResponse> findAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> findById (@PathVariable ("id") Long id) throws IdNotFoundException {
        return new ResponseEntity<>(mapper.userEntityToUserResponse(userService.findById(id)), HttpStatus.ACCEPTED);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) throws IdNotFoundException, UserExistException {
        UserEntity oldUser = userService.findById(id);

        UserEntity newUser = UserEntity
                .builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();

        UserDTO newUserDto = mapper.userEntityToUserDTO(newUser);

        return new ResponseEntity<>(mapper.userEntityToUserResponse(userService.saveUser(newUserDto)),HttpStatus.OK);


    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUser(){
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") Long id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
