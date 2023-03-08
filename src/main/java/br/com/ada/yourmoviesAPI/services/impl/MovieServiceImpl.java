package br.com.ada.yourmoviesAPI.services.impl;

import br.com.ada.yourmoviesAPI.client.MovieOMDBFeign;
import br.com.ada.yourmoviesAPI.dto.MovieDTO;
import br.com.ada.yourmoviesAPI.dto.UserDTO;
import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.entities.UserEntity;
import br.com.ada.yourmoviesAPI.repository.MovieRepository;
import br.com.ada.yourmoviesAPI.services.IMovieService;
import br.com.ada.yourmoviesAPI.services.IUserService;
import br.com.ada.yourmoviesAPI.vo.MovieOMDB;
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

    public MovieOMDB getMovie (String theme){
        return movieOMDBFeign.getMovie(theme,apiKey);
    }

    public MovieEntity convertDTOtoEntity (MovieDTO movieDTO){
        return MovieEntity.builder()
                .nameMovie(movieDTO.getNameMovie())
                .genre(movieDTO.getGenre())
                .imdbRating(movieDTO.getImdbRating())
                .yearMovie(movieDTO.getYearMovie())
                .build();
    }


    @Override
    public MovieEntity saveMovie(MovieDTO movie) {
        MovieEntity movieEntity = convertDTOtoEntity(movie);
        return movieRepository.save(movieEntity);
    }

    @Override
    public MovieEntity findByEmail(String email) {
        return null;
    }

    @Override
    public List<MovieEntity> findAllMovies() {
        return null;
    }

    @Override
    public void deleteById(Long id) {


    }

    @Override
    public MovieEntity getById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Movie not found")); //TODO fazer uma excepction especifica
    }
}
