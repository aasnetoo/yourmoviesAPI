package br.com.ada.yourmoviesAPI.services;

import br.com.ada.yourmoviesAPI.dto.MovieDTO;
import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.response.MovieResponse;

import java.util.List;

public interface IMovieService {

    MovieEntity saveMovie(MovieDTO movie);
    MovieEntity findByTitle (String title);
    List<MovieResponse> findByUserId(Long userId);
    void deleteById(Long id);
    MovieEntity getById (Long id) throws IdNotFoundException;
    void deleteByUserId (Long userId);

}
