package br.com.ada.yourmoviesAPI.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "db_movies")
public class MoviesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameMovie;
    private String genre;

    private Long yearMovie;

    private Double imdbRating;

    private Double yourRating;

    private Long users_id;


}
