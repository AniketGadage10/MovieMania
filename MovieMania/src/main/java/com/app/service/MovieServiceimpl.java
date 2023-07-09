package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DTO.MovieDTO;
import com.app.DTO.UpdateMovieDTO;
import com.app.entities.Director;
import com.app.entities.Movie;
import com.app.entities.Rating;
import com.app.exception.customexception;
import com.app.repository.DirectorRepo;
import com.app.repository.MovieRepo;

@Service
@Transactional
public class MovieServiceimpl implements MovieService {
	@Autowired
	private DirectorRepo drepo;
	@Autowired
	private MovieRepo mrepo;
	@Autowired
	private ModelMapper mp;

	public MovieDTO insert(MovieDTO m) {
		Director d = drepo.findById(m.getDid()).orElseThrow(() -> new customexception("Director Not Found"));
		Movie m1 = mp.map(m, Movie.class);
		d.add(m1);
		return mp.map(mrepo.save(m1), MovieDTO.class);
	}

	public Director get(String rating) {
		Rating R = Rating.valueOf(rating);
		Movie d = mrepo.findByRate(R);
		return d.getDirector();
	}

	public Movie put(UpdateMovieDTO mid) {
		Movie d = mrepo.findById(mid.getDid()).orElseThrow(() -> new customexception("Movie Not Found"));
		d.setRdate(mid.getRdate());
		return mrepo.save(d);
	}

	public String delete(Long id, Long mid) {
		Director d = drepo.findById(id).orElseThrow(() -> new customexception("Director Not Found"));
		Movie m = mrepo.findById(mid).orElseThrow(() -> new customexception("Movie Not Found"));
		d.remove(m);
		return "delete by id Sucessfull";
	}

}
