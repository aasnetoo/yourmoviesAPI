package br.com.ada.yourmoviesAPI.services;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.request.UserRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    UserDTO saveUser(UserRequest user);
    UserEntity findByEmail (String email) throws IdNotFoundException;
    List<UserEntity> findAllUsers();
    void deleteById(Long id);


    UserDTO findById(Long id) throws IdNotFoundException;


}
