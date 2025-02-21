package com.xyz.movies.show_service.service;

import java.time.LocalDate;
import java.util.List;

import com.xyz.movies.show_service.dto.ShowCreateDTO;
import com.xyz.movies.show_service.dto.ShowDTO;
import com.xyz.movies.show_service.dto.ShowUpdateDTO;

public interface ShowService {
	
	void createShow(ShowCreateDTO showCreateDTO);
	List<ShowDTO> getShowsByMovieDateAndTown(Long movieId, LocalDate date, Long townId);
	void updateShow(ShowUpdateDTO showUpdateDTO);
	void deleteShow(Long showId);
}
