package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "mlist")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
public class Director extends BaseEntity {

	@Column(length = 20)
	private String dname;
	@Column(length = 30)
	private String email;
	private String password;
	private LocalDate dob;
	private int age;
	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Movie> mlist = new ArrayList<>();

	public void add(Movie m) {
		mlist.add(m);
		m.setDirector(this);
	}

	public void remove(Movie m) {
		mlist.remove(m);
		m.setDirector(null);
	}
}
