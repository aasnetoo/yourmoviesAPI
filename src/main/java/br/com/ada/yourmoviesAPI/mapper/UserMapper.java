package br.com.ada.yourmoviesAPI.mapper;

import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.request.UserRequest;
import br.com.ada.yourmoviesAPI.response.UserResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userEntityToUserDTO (UserEntity entity);
    UserEntity userDTOToUserEntity (UserDTO dto);
    UserResponse userDTOToUserReponse(UserDTO dto);

    @Named("mapWithoutIdAndPassword")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserEntity userResponseToUserEntity (UserResponse response);
    @InheritInverseConfiguration
    UserResponse userEntityToUserResponse (UserEntity entity);


    UserRequest UserDTOToUserRequest(UserDTO dto);


    UserDTO UserRequestToUserDTO (UserRequest request);

    List<UserResponse> listUserEntityToListUserResponse(List<UserEntity> entities);



}
