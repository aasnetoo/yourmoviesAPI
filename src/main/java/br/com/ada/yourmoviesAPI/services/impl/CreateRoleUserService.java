package br.com.ada.yourmoviesAPI.services.impl;

import br.com.ada.yourmoviesAPI.dto.CreateUserRoleDTO;
import br.com.ada.yourmoviesAPI.entities.RoleEntity;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.UserExistException;
import br.com.ada.yourmoviesAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateRoleUserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity execute(CreateUserRoleDTO createUserRoleDTO) throws UserExistException {
        Optional<UserEntity> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
        List<RoleEntity> roles = new ArrayList<>();

        if (userExists.isEmpty()){
            throw new UserExistException();
        }

        roles = createUserRoleDTO.getIdsRoles().stream().map(RoleEntity::new).collect(Collectors.toList());
        UserEntity user = userExists.get();
        user.setRoles(roles);
        userRepository.save(user);

        return user;
    }


}
