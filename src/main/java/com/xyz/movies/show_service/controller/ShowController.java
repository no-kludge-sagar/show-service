package com.xyz.movies.show_service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.movies.show_service.dto.ShowCreateDTO;
import com.xyz.movies.show_service.dto.ShowDTO;
import com.xyz.movies.show_service.service.ShowService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/show")
@AllArgsConstructor
public class ShowController {
	
	private ShowService showService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createShow(@Valid @RequestBody ShowCreateDTO showCreateDTO) {
        showService.createShow(showCreateDTO);
	}
	
	@GetMapping("/getShowsByMovieDateAndTown")
	public List<ShowDTO> getShowsByMovieDateAndTown(@RequestParam Long movieId, @RequestParam LocalDate date, @RequestParam Long townId) {
		return showService.getShowsByMovieDateAndTown(movieId, date, townId);
	}
	
	@DeleteMapping
	public void deleteShow(@RequestParam Long showId) {
		showService.deleteShow(showId);
	}

}
