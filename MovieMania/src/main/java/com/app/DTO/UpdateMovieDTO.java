package com.app.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMovieDTO {
	@Positive(message = "Id Must Be Positive")
	private Long did;
	@NotBlank(message = "Movie Must Be Field")
	private String mname;
	@NotBlank(message = "Rate Must Be Field")
	private String rate;
	@Future(message = "Date Must Be Future")
	private LocalDate rdate;
	@Positive(message = "Dudget Must Be positive")
	private double budget;
}
