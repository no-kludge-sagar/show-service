package com.xyz.movies.show_service.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ShowDTO {

	private Long id;
	private String movie;
    private String theatre;
    private LocalDate date;
    private LocalTime time;

}
