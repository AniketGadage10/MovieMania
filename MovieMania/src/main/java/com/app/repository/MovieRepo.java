package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Director;
import com.app.entities.Movie;
import com.app.entities.Rating;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	Movie findByRate(Rating r);
}
