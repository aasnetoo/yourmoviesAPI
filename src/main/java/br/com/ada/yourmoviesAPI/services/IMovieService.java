package br.com.ada.yourmoviesAPI.services;

import br.com.ada.yourmoviesAPI.dto.MovieDTO;
import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;

import java.util.List;

public interface IMovieService {

    MovieEntity saveMovie(MovieDTO movie);
    MovieEntity findByTitle (String email);
    List<MovieEntity> findAllMovies();
    void deleteById(Long id);
    MovieEntity getById (Long id) throws IdNotFoundException;
}
