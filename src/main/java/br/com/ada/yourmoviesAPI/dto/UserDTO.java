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

    private Long id;
    private String name;
    private String email;
    private String password;


}
