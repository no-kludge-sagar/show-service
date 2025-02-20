package com.xyz.movies.show_service.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.xyz.movies.show_service.dto.ShowDTO;
import com.xyz.movies.show_service.entity.repository.ShowRepository;
import com.xyz.movies.show_service.exception.ResourceNotFoundException;
import com.xyz.movies.show_service.service.ShowService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {
	
	private ModelMapper modelMapper;
	private ShowRepository showRepository;
	
	@Override
	public List<ShowDTO> getShowsByMovieDateAndTown(Long movieId, LocalDate date, Long townId) {
		List<ShowDTO> showDTOs = showRepository.findShowsByMovieDateAndTown(movieId, date, townId)
											.stream().map(show -> modelMapper.map(show, ShowDTO.class)).toList();
		if (showDTOs.size()	> 0)
			return showDTOs;
		
		throw new ResourceNotFoundException("Show");
	}

	@Override
	public boolean deleteShow(Long showId) {
		if (showRepository.existsById(showId)) {
            showRepository.deleteById(showId);
            return true;
		}
		return false;
	}


}
