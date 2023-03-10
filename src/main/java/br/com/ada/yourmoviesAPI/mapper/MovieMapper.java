package br.com.ada.yourmoviesAPI.mapper;

import br.com.ada.yourmoviesAPI.dto.MovieDTO;
import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.request.MovieRequest;
import br.com.ada.yourmoviesAPI.response.MovieResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    List<MovieResponse> listMovieEntityToListMovieResponse (List<MovieEntity> movies);

    MovieResponse movieEntityToMovieResponse (MovieEntity movieEntity);

    MovieDTO movieRequestToMovieDTO (MovieRequest movieRequest);

    MovieEntity movieRequestToMovieEntity (MovieRequest movieRequest);

    MovieEntity movieDtoToMovieENtity (MovieDTO movieDTO);

}
