package br.com.ada.yourmoviesAPI.response;

import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import lombok.*;
import org.apache.catalina.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieResponse {

    private Long id;
    private String title;
    private String genre;

    private Long yearMovie;

    private Double imdbRating;



}
