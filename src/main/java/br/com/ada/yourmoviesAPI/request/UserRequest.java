package br.com.ada.yourmoviesAPI.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequest;
    private String name;
    private String email;
    private String password;
}
