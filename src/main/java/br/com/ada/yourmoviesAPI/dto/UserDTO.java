package br.com.ada.yourmoviesAPI.dto;

import br.com.ada.yourmoviesAPI.entities.UserEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String name;
    private String email;

    public UserDTO convertUserEntityToDTO (UserEntity userEntity){
        BeanUtils.copyProperties(userEntity,this,"id", "password", "moviesEntity");
        return this;
    }

}
