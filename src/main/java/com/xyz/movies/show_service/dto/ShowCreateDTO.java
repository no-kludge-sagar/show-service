package com.xyz.movies.show_service.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShowCreateDTO {

	@NotNull(message = "Movie Id cannot be null or empty")
	private Long movieId;
	@NotNull(message = "Theatre Id cannot be null or empty")
    private Long theatreId;
	@NotNull(message = "Show date cannot be null or empty")
    private LocalDate date;
	@NotNull(message = "Show time cannot be null or empty")
    private LocalTime time;

}
