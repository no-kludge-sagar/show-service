package com.xyz.movies.show_service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.movies.show_service.dto.ShowDTO;
import com.xyz.movies.show_service.service.ShowService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/show")
@AllArgsConstructor
public class ShowController {
	
	private ShowService showService;
	
	@GetMapping("/getShowsByMovieDateAndTown")
	public List<ShowDTO> getShowsByMovieDateAndTown(@RequestParam Long movieId, @RequestParam LocalDate date, @RequestParam Long townId) {
		return showService.getShowsByMovieDateAndTown(movieId, date, townId);
	}

}
