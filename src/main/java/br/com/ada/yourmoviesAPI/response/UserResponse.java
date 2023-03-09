package br.com.ada.yourmoviesAPI.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String name;
    private String email;
}
