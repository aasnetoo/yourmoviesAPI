package br.com.ada.yourmoviesAPI.request;

import br.com.ada.yourmoviesAPI.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRequest {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Year")
    private Long yearMovie;
    private Double imdbRating;

    private UserEntity user;
}
