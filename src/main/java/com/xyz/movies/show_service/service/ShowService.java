package com.xyz.movies.show_service.service;

import java.time.LocalDate;
import java.util.List;

import com.xyz.movies.show_service.dto.ShowDTO;

public interface ShowService {
	
	List<ShowDTO> getShowsByMovieDateAndTown(Long movieId, LocalDate date, Long townId);
}
