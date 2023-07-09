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

import com.app.DTO.DirectorDTO;
import com.app.service.DirectorServiceimpl;

@RestController
@RequestMapping("/Directors")
public class DirectorController {

	@Autowired
	private DirectorServiceimpl dser;

	@GetMapping("/{dname}")
	public ResponseEntity<?> getlist(@PathVariable String dname) {
		return ResponseEntity.status(HttpStatus.OK).body(dser.get(dname));
	}
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody @Valid DirectorDTO d) {
		return ResponseEntity.status(HttpStatus.OK).body(dser.insert(d));
	}
	@PutMapping("/{email}/{age}")
	public ResponseEntity<?> put(@PathVariable String email,@PathVariable int age) {
		return ResponseEntity.status(HttpStatus.OK).body(dser.put(email,age));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(dser.delete(id));
	}
}
