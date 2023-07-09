package com.app.service;

import javax.validation.Valid;

import com.app.DTO.DirectorDTO;
import com.app.DTO.apiresponseDTO;

public interface DirectorService {
	DirectorDTO insert(@Valid DirectorDTO d);
	
	String delete(Long did);
}
