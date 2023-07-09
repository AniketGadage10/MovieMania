package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.MovieDTO;
import com.app.DTO.UpdateMovieDTO;
import com.app.service.MovieServiceimpl;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieServiceimpl mser;
	
	@PostMapping
	public ResponseEntity<?> insertMovie(@RequestBody @Valid MovieDTO m)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(mser.insert(m));
	}	
	@GetMapping("/{rating}")
	public ResponseEntity<?> getlist(@PathVariable String rating)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(mser.get(rating));
	}
	
	@PutMapping
	public ResponseEntity<?> put(@RequestBody UpdateMovieDTO mid)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(mser.put(mid));
	}
	
	
	
	@DeleteMapping("/{did}/{mid}")
	public ResponseEntity<?> delete(@PathVariable Long did,@PathVariable Long mid) {
		System.out.println(did+"  "+mid);
		return ResponseEntity.status(HttpStatus.OK).body(mser.delete(did,mid));
	}
	
}
