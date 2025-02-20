package com.xyz.movies.show_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xyz.movies.show_service.dto.ShowDTO;
import com.xyz.movies.show_service.entity.Show;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Custom Mapping: Nested Fields (Movie Title & Theatre Name)
        modelMapper.typeMap(Show.class, ShowDTO.class).addMappings(mapper -> {
            mapper.map(show -> show.getMovie().getTitle(), ShowDTO::setMovie);
            mapper.map(show -> show.getTheatre().getName(), ShowDTO::setTheatre);
        });

        return modelMapper;
    }
}


