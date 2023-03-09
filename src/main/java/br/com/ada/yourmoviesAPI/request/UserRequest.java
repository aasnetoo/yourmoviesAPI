package br.com.ada.yourmoviesAPI.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Email
    private String email;
    @Min(8)
    private String password;
}
