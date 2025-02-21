package com.xyz.movies.show_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShowUpdateDTO extends ShowCreateDTO {
	@NotNull
	private Long id;

}
