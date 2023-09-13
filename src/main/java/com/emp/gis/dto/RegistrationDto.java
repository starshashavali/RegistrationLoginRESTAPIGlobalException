package com.emp.gis.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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
public class RegistrationDto {

	private Integer id;
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String name;

	@NotNull
	@Size(min = 6, message = "user name should have at least 6 characters")
	private String email;

	@NotNull
	@Size(min = 6, message = "user name should have at least 6 characters")
	private String pwd;

	@Min(value = 18, message = "Age must be at least 18")
	@Max(value = 99, message = "Age must be less than 100")
	private Integer age;
}
