package br.com.ada.yourmoviesAPI.controller;

import br.com.ada.yourmoviesAPI.dto.MovieDTO;
import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import br.com.ada.yourmoviesAPI.repository.MovieRepository;
import br.com.ada.yourmoviesAPI.services.impl.MovieServiceImpl;
import br.com.ada.yourmoviesAPI.vo.MovieOMDB;
import br.com.ada.yourmoviesAPI.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;
    @Autowired
    private MovieRepository movieRepository;


    @GetMapping("/omdb/{theme}")
    public ResponseEntity<MovieOMDB> getMovie(@PathVariable String theme){
        try {
            MovieOMDB movieOMDB = movieService.getMovie(theme);
            return ResponseEntity.status(HttpStatus.OK).body(movieOMDB);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
    @PostMapping
    public ResponseEntity<MovieVO> saveMovie (@RequestBody MovieDTO movieDTO){
        try{
            MovieVO movieVO = MovieVO.builder().build().convertMovieEntityToVO(movieService.saveMovie(movieDTO));

            return ResponseEntity.status(HttpStatus.CREATED).body(movieVO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieVO> getById (@PathVariable("id") Long id){
        try{
            MovieVO movieVO = MovieVO.builder().build().convertMovieEntityToVO(movieService.getById(id));

            return ResponseEntity.status(HttpStatus.CREATED).body(movieVO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
