package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Director;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Long>{
	Optional<Director> findByDname(String dname);
	
	 Optional<Director> findByEmail(String email);
}
