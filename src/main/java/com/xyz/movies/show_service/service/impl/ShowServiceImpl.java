package com.xyz.movies.show_service.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.xyz.movies.show_service.dto.ShowCreateDTO;
import com.xyz.movies.show_service.dto.ShowDTO;
import com.xyz.movies.show_service.entity.Movie;
import com.xyz.movies.show_service.entity.Show;
import com.xyz.movies.show_service.entity.Theatre;
import com.xyz.movies.show_service.entity.repository.MovieRepository;
import com.xyz.movies.show_service.entity.repository.ShowRepository;
import com.xyz.movies.show_service.entity.repository.TheatreRepository;
import com.xyz.movies.show_service.exception.ResourceAlreadyExistsException;
import com.xyz.movies.show_service.exception.ResourceNotFoundException;
import com.xyz.movies.show_service.service.ShowService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {
	
	private ModelMapper modelMapper;
	private ShowRepository showRepository;
	private MovieRepository movieRepository;
	private TheatreRepository theatreRepository;
	
	@Override
	public void createShow(ShowCreateDTO showCreateDTO) {
		Movie movie = movieRepository.findById(showCreateDTO.getMovieId())
                						.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", showCreateDTO.getMovieId().toString()));
        Theatre theatre = theatreRepository.findById(showCreateDTO.getTheatreId())
                							.orElseThrow(() -> new ResourceNotFoundException("Theatre", "id", showCreateDTO.getTheatreId().toString()));

        Show show = new Show(movie, theatre, showCreateDTO.getDate(), showCreateDTO.getTime());
        try {
			showRepository.save(show);
		} catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			throw new ResourceAlreadyExistsException("Show");
		}
		
	}
	
	@Override
	public List<ShowDTO> getShowsByMovieDateAndTown(Long movieId, LocalDate date, Long townId) {
		List<ShowDTO> showDTOs = showRepository.findShowsByMovieDateAndTown(movieId, date, townId)
												.stream().map(show -> modelMapper.map(show, ShowDTO.class)).toList();
		if (showDTOs.size()	> 0)
			return showDTOs;
		
		throw new ResourceNotFoundException("Show");
	}

	@Override
	public void deleteShow(Long showId) {
		if (showRepository.existsById(showId)) {
            showRepository.deleteById(showId);
		} else {
			throw new ResourceNotFoundException("Show");
		}
	}

}
