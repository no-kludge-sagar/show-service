package com.xyz.movies.show_service.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.movies.show_service.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
