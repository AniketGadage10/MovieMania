package com.app.DTO;

import java.time.LocalDate;

import java.time.LocalDate;

public class apiresponseDTO {

	private String msg;
	private LocalDate date;
	
	public apiresponseDTO(String msg) {
		this.msg=msg;
		this.date=LocalDate.now();
	}
}
