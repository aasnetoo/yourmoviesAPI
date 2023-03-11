package br.com.ada.yourmoviesAPI.controller;

import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.exceptions.ResourceNotFoundException;
import br.com.ada.yourmoviesAPI.mapper.MovieMapper;
import br.com.ada.yourmoviesAPI.repository.MovieRepository;
import br.com.ada.yourmoviesAPI.repository.UserRepository;
import br.com.ada.yourmoviesAPI.request.MovieRequest;
import br.com.ada.yourmoviesAPI.services.impl.MovieServiceImpl;
import br.com.ada.yourmoviesAPI.response.MovieOMDB;
import br.com.ada.yourmoviesAPI.response.MovieResponse;
import br.com.ada.yourmoviesAPI.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yourmovies")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieMapper mapper;


    @GetMapping("/omdb/{theme}")
    public ResponseEntity<MovieOMDB> getMovie(@RequestParam String theme){
        try {
            MovieOMDB movieOMDB = movieService.getMovie(theme);
            return ResponseEntity.status(HttpStatus.OK).body(movieOMDB);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
    @PostMapping("/users/{userid}/save")
    public ResponseEntity<MovieEntity> saveMovie (@PathVariable(value = "userid") Long userId, @RequestBody MovieRequest movieRequest){
        try{
            MovieEntity movieEntity = userRepository.findById(userId).map(user -> {
                movieRequest.setUser(user);
                return movieRepository.save(mapper.movieRequestToMovieEntity(movieRequest));
            }).orElseThrow(ResourceNotFoundException::new);

            return new ResponseEntity<>(movieEntity,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/users/{userid}/allmovies")
    public ResponseEntity<List<MovieResponse>> getAllMoviesByUserId(@PathVariable(value = "userid") Long userId) throws ResourceNotFoundException {
        if (userService.existsById(userId)){
            throw new ResourceNotFoundException();
        }
        List<MovieResponse> movies = movieService.findByUserId(userId);
        return new ResponseEntity<>(movies, HttpStatus.OK);

    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieEntity> getById (@PathVariable(value = "id") Long id){
        try{
            MovieEntity movieResponse = movieService.getById(id);

            return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<HttpStatus> deleteMovieById (@PathVariable("id") Long id){
        movieService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{userid}/movies")
    public ResponseEntity<HttpStatus> deleteAllMoviesOfAnUser(@PathVariable(value = "userid") Long userid) throws ResourceNotFoundException {
        if (!userService.existsById(userid)){
            throw new ResourceNotFoundException();
        }
        movieService.deleteByUserId(userid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
