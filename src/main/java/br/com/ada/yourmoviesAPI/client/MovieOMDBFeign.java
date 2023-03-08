package br.com.ada.yourmoviesAPI.client;


import br.com.ada.yourmoviesAPI.vo.MovieOMDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="omdbMovies", url = "http://www.omdbapi.com/")
public interface MovieOMDBFeign {

    @RequestMapping(method = RequestMethod.GET)
    MovieOMDB getMovie(@RequestParam("t") String theme, @RequestParam("apiKey") String key);

}
