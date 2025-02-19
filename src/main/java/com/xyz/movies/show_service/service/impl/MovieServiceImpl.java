package com.xyz.movies.show_service.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.xyz.movies.show_service.dto.MovieDTO;
import com.xyz.movies.show_service.entity.MovieRepository;
import com.xyz.movies.show_service.service.MovieService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
	
	private ModelMapper modelMapper;
	private MovieRepository movieRepository;

	@Override
	public List<MovieDTO> getAllMovies() {
		List<MovieDTO> movieDTOs = movieRepository.findAll().stream().map(movie -> modelMapper.map(movie, MovieDTO.class)).toList();
		return movieDTOs;	
	}

}
