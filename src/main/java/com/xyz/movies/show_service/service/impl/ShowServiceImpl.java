package com.xyz.movies.show_service.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.xyz.movies.show_service.dto.ShowCreateDTO;
import com.xyz.movies.show_service.dto.ShowDTO;
import com.xyz.movies.show_service.dto.ShowUpdateDTO;
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
	
	private static final String ID = "id";
	private static final String MOVIE = "Movie";
	private static final String THEATRE = "Theatre";
	private static final String SHOW = "Show";
	
	@Override
	public void createShow(ShowCreateDTO showCreateDTO) {
		Movie movie = movieRepository.findById(showCreateDTO.getMovieId())
                						.orElseThrow(() -> new ResourceNotFoundException(MOVIE, ID, showCreateDTO.getMovieId().toString()));
        Theatre theatre = theatreRepository.findById(showCreateDTO.getTheatreId())
                							.orElseThrow(() -> new ResourceNotFoundException(THEATRE, ID, showCreateDTO.getTheatreId().toString()));

        Show show = new Show(movie, theatre, showCreateDTO.getDate(), showCreateDTO.getTime());
        try {
			showRepository.save(show);
		} catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			throw new ResourceAlreadyExistsException(SHOW);
		}
		
	}
	
	@Override
	public List<ShowDTO> getShowsByMovieDateAndTown(Long movieId, LocalDate date, Long townId) {
		List<ShowDTO> showDTOs = showRepository.findShowsByMovieDateAndTown(movieId, date, townId)
												.stream().map(show -> modelMapper.map(show, ShowDTO.class)).toList();
		if (showDTOs.size()	> 0)
			return showDTOs;
		
		throw new ResourceNotFoundException(SHOW);
	}
	
	@Override
	public void updateShow(ShowUpdateDTO showUpdateDTO) {
		Show show = showRepository.findById(showUpdateDTO.getId())
									.orElseThrow(() -> new ResourceNotFoundException(SHOW, ID, showUpdateDTO.getId().toString()));
		Movie movie = movieRepository.findById(showUpdateDTO.getMovieId())
										.orElseThrow(() -> new ResourceNotFoundException(MOVIE, ID, showUpdateDTO.getMovieId().toString()));
		Theatre theatre = theatreRepository.findById(showUpdateDTO.getTheatreId())
											.orElseThrow(() -> new ResourceNotFoundException(THEATRE, ID, showUpdateDTO.getTheatreId().toString()));

		show = new Show(showUpdateDTO.getId(), movie, theatre, showUpdateDTO.getDate(), showUpdateDTO.getTime());
		try {
			showRepository.save(show);
		} catch (DataIntegrityViolationException ex) {
			ex.printStackTrace();
			throw new ResourceAlreadyExistsException(SHOW);
		}

	}

	@Override
	public void deleteShow(Long showId) {
		if (showRepository.existsById(showId)) {
            showRepository.deleteById(showId);
		} else {
			throw new ResourceNotFoundException(SHOW);
		}
	}

}
