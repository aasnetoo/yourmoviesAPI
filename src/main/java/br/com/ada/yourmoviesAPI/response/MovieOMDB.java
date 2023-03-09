package br.com.ada.yourmoviesAPI.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieOMDB {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Year")
    private Long yearMovie;
    @JsonProperty("imdbRating")
    private Double imdbRating;



}
