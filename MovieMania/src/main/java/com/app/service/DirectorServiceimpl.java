package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DTO.DirectorDTO;
import com.app.entities.Director;
import com.app.entities.Movie;
import com.app.exception.customexception;
import com.app.repository.DirectorRepo;
import com.app.repository.MovieRepo;

@Service
@Transactional
public class DirectorServiceimpl implements DirectorService {
	@Autowired
	private DirectorRepo drepo;
	@Autowired
	private MovieRepo mrepo;
	@Autowired
	private ModelMapper mp;

	public DirectorDTO insert(DirectorDTO d) {
		Director d1 = mp.map(d, Director.class);
		return mp.map(drepo.save(d1), DirectorDTO.class);

	}

	public List<Movie> get(String dname) {
		Director d = drepo.findByDname(dname).orElseThrow(() -> new customexception("Director By Name Not Present"));
		return d.getMlist();
	}

	public Director put(String email, int age) {
		Director d = drepo.findByEmail(email).orElseThrow(() -> new customexception("Director By Name Not Present"));
		d.setAge(age);
		return drepo.save(d);
	}

	public String delete(Long did) {
		String msg = "Delete By Id Is Not Exists";
		if (drepo.existsById(did)) {
			drepo.deleteById(did);
			msg = "delete by id Sucessfull";
		}
		return msg;
	}
}
