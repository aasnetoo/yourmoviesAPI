package br.com.ada.yourmoviesAPI.mapper;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO UserEntityToUserDTO (UserEntity entity);
    UserEntity UserDTOtoUserEntity (UserDTO dto);
    UserResponse UserDTOtoUserReponse(UserDTO dto); //TODO Resolver o problema do source target pois n tem os campoos

    @Mapping(source = "idRequest", target = "id")
    UserDTO UserRequestToUserDTO(UserRequest request);


}
