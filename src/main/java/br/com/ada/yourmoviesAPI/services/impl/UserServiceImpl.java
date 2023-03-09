package br.com.ada.yourmoviesAPI.services.impl;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.repository.UserRepository;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserRequest userEntity) {
        UserDTO userDTO = UserDTO.builder().build().convertUserEntityToDTO(userEntity);
        boolean userExist = userRepository.findAll().stream().anyMatch(user-> user.equals(userEntity));
        if (userEntity.getPassword().length() < 8){
            throw new IllegalArgumentException("A senha deve ser superior a 8 caracteres!");
        }
        if (!userExist){
            userRepository.save(userEntity);
        }
        return userDTO;
    }

    @Override
    public UserEntity findByEmail(String email) throws IdNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(IdNotFoundException::new);

    }


    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findById(Long id) throws IdNotFoundException {
        var userEntity = userRepository.findById(id).orElseThrow(IdNotFoundException::new);
        return UserDTO.builder().build().convertUserEntityToDTO(userEntity);
    }



}
