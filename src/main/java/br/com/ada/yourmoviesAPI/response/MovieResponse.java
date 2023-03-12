package br.com.ada.yourmoviesAPI.response;


import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieResponse {

    private Long id;
    private String title;
    private String genre;

    private Long yearMovie;

    private Double imdbRating;



}
