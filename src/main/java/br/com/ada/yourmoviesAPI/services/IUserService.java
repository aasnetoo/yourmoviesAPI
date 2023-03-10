package br.com.ada.yourmoviesAPI.services;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.exceptions.UserExistException;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    UserEntity saveUser(UserDTO user) throws UserExistException;
    UserEntity findByEmail (String title) throws IdNotFoundException;
    List<UserResponse> findAllUsers();
    void deleteById(Long id);
    Boolean existsById (Long id);

    UserResponse findById(Long id) throws IdNotFoundException;


}
