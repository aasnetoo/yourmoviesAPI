package br.com.ada.yourmoviesAPI.response;

import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieResponse {

    private Long id;
    private String title;
    private String genre;

    private Long yearMovie;

    private Double imdbRating;

    public MovieResponse convertMovieEntityToVO (MovieEntity movieEntity){
        return MovieResponse.builder()
                .id(movieEntity.getId())
                .title(movieEntity.getTitle())
                .genre(movieEntity.getGenre())
                .imdbRating(movieEntity.getImdbRating())
                .yearMovie(movieEntity.getYearMovie())
                .build();
    }
}
