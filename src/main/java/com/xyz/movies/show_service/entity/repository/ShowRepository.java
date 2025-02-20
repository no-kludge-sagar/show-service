package com.xyz.movies.show_service.entity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyz.movies.show_service.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

	@Query("SELECT s FROM Show s JOIN s.theatre t WHERE s.movie.id = :movieId AND s.date = :date AND t.town.id = :townId")
	List<Show> findShowsByMovieDateAndTown(@Param("movieId") Long movieId, @Param("date") LocalDate date, @Param("townId") Long townId);

}
