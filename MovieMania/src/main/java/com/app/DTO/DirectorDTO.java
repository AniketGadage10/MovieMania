package com.app.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

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
public class DirectorDTO {	
	@NotBlank(message = "Dname Must Be Given")
	private String dname;
	@Email(message = "Email Not Valid ")
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[@#])[a-zA-Z0-9@#]{5,10}$", message = "Invalid Password")
	private String password;
	@Past(message = "Date Must Be Past")
	private LocalDate dob;
	@Min(18)
	private int age;
}
