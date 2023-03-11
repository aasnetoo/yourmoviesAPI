package br.com.ada.yourmoviesAPI.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 15, message = "A senha deve ter entre 4 e 15 caracteres.")
    private String password;
}
