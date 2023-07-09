package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.DTO.MovieDTO;
import com.app.DTO.UpdateMovieDTO;
import com.app.entities.Director;
import com.app.entities.Movie;

public interface MovieService {
	MovieDTO insert(@Valid MovieDTO m);
	
	Director get(String rating);
	
	Movie put(UpdateMovieDTO mid);
}
