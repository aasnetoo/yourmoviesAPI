package br.com.ada.yourmoviesAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "db_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private String password;

    @OneToMany
    @JoinColumn(name = "users_id")
    private Set<MovieEntity> moviesEntity;





}
