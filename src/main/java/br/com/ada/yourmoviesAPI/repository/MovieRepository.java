package br.com.ada.yourmoviesAPI.repository;

import br.com.ada.yourmoviesAPI.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
    List<MovieEntity> findByUserId(Long postId);
}
