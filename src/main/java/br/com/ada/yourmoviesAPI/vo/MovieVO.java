package br.com.ada.yourmoviesAPI.vo;

import br.com.ada.yourmoviesAPI.dto.MovieDTO;
import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieVO{

    private Long id;
    private String title;
    private String genre;

    private Long yearMovie;

    private Double imdbRating;

    public MovieVO convertMovieEntityToVO (MovieEntity movieEntity){
        return MovieVO.builder()
                .id(movieEntity.getId())
                .title(movieEntity.getTitle())
                .genre(movieEntity.getGenre())
                .imdbRating(movieEntity.getImdbRating())
                .yearMovie(movieEntity.getYearMovie())
                .build();
    }
}
