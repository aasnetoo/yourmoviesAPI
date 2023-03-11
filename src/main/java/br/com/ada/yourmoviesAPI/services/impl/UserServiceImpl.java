package br.com.ada.yourmoviesAPI.services.impl;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.exceptions.UserExistException;
import br.com.ada.yourmoviesAPI.mapper.UserMapper;
import br.com.ada.yourmoviesAPI.repository.UserRepository;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.response.UserResponse;
import br.com.ada.yourmoviesAPI.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    @Override
    public UserEntity saveUser(UserDTO userDTO) throws UserExistException {
        UserEntity userEntity = mapper.userDTOToUserEntity(userDTO);
        boolean userExist = userRepository.findAll().stream().anyMatch(user-> user.equals(userEntity));
//        if (userEntity.getPassword().length() < 8){
//            throw new IllegalArgumentException("A senha deve ser superior a 8 caracteres!");
//        }
        if (userExist){
            throw new UserExistException();
        }
        userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity findByEmail(String email) throws IdNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(IdNotFoundException::new);

    }


    @Override
    public List<UserResponse> findAllUsers() {
        return mapper.listUserEntityToListUserResponse(userRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
       return userRepository.existsById(id);
    }

    @Override
    public UserResponse findById(Long id) throws IdNotFoundException {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(IdNotFoundException::new);
        return mapper.userEntityToUserResponse(userEntity);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }


}
