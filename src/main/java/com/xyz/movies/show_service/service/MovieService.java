package com.xyz.movies.show_service.service;

import java.util.List;

import com.xyz.movies.show_service.dto.MovieDTO;

public interface MovieService {
	
	List<MovieDTO> getAllMovies();
}
