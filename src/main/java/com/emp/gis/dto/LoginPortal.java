package com.emp.gis.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginPortal {
	
	@NotNull
	@Size(min = 6, message = "user name should have at least 6 characters")
	private String email;

	@NotNull
	@Size(min = 6, message = "user name should have at least 6 characters")
	private String pwd;

}
