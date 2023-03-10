package br.com.ada.yourmoviesAPI.services.impl;

import br.com.ada.yourmoviesAPI.client.MovieOMDBFeign;
import br.com.ada.yourmoviesAPI.dto.MovieDTO;
import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.exceptions.IdNotFoundException;
import br.com.ada.yourmoviesAPI.mapper.MovieMapper;
import br.com.ada.yourmoviesAPI.repository.MovieRepository;
import br.com.ada.yourmoviesAPI.response.MovieResponse;
import br.com.ada.yourmoviesAPI.services.IMovieService;
import br.com.ada.yourmoviesAPI.response.MovieOMDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Value("${imdb.apikey}")
    private String apiKey;

    @Autowired
    private MovieOMDBFeign movieOMDBFeign;

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper mapper;

    public MovieOMDB getMovie (String theme){
        return movieOMDBFeign.getMovie(theme,apiKey);
    }



    @Override
    public MovieEntity saveMovie(MovieDTO movie) {
        MovieEntity movieEntity = mapper.movieDtoToMovieENtity(movie);
        return movieRepository.save(movieEntity);
    }

    @Override
    public MovieEntity findByTitle(String title) {
        return null;
    }

    @Override
    public List<MovieResponse> findByUserId(Long userId) {
        return mapper.listMovieEntityToListMovieResponse(movieRepository.findByUserId(userId));
    }


    @Override
    public void deleteById(Long id) {


    }


    @Override
    public MovieEntity getById(Long id) throws IdNotFoundException {
        return movieRepository.findById(id).orElseThrow(IdNotFoundException::new); //TODO fazer uma excepction especifica
    }
}
