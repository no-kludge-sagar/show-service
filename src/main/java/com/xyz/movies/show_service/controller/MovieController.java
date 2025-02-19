package com.xyz.movies.show_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.movies.show_service.dto.MovieDTO;
import com.xyz.movies.show_service.service.MovieService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/movie")
@AllArgsConstructor
public class MovieController {
	
	private MovieService movieService;
	
	@GetMapping
	public List<MovieDTO> getAllMovies() {
		return movieService.getAllMovies();
	}

}
