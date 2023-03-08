package br.com.ada.yourmoviesAPI.services.impl;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.repository.UserRepository;
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
    public UserDTO saveUser(UserEntity userEntity) {
        UserDTO userDTO = UserDTO.builder().build().convertEntityToDTO(userEntity);
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
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null); //TODO fazer uma exception

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
    public UserDTO findById(Long id) {
        var userEntity = userRepository.findById(id).orElse(null);
        return UserDTO.builder().build().convertEntityToDTO(userEntity);
    }



}
