package br.com.ada.yourmoviesAPI.dto;


import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRoleDTO {

    private UUID idUser;
    private List<UUID> idsRoles;

}
