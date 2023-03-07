package br.com.ada.yourmoviesAPI.repository;

import br.com.ada.yourmoviesAPI.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity,Long> {
}
