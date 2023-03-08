package br.com.ada.yourmoviesAPI.dto;

import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieDTO {

    private String nameMovie;
    private String genre;

    private Long yearMovie;

    private Double imdbRating;





}
