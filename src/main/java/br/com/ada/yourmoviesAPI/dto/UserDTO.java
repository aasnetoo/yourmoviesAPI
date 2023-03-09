package br.com.ada.yourmoviesAPI.dto;

import br.com.ada.yourmoviesAPI.entities.UserEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String name;
    @Email(message = "Email nao e valido")
    @NotEmpty(message = "Email nao pode ser vazio.")
    private String email;



    public UserDTO convertUserEntityToDTO (UserEntity userEntity){
        BeanUtils.copyProperties(userEntity,this,"id", "password", "moviesEntity");
        return this;
    }

}
