package br.com.ada.yourmoviesAPI.services;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    UserDTO saveUser(UserEntity user);
    UserEntity findByEmail (String email);
    List<UserEntity> findAllUsers();
    void deleteById(Long id);


}
