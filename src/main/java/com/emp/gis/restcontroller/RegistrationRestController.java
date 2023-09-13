package com.emp.gis.restcontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.gis.dto.LoginPortal;
import com.emp.gis.dto.RegistrationDto;
import com.emp.gis.service.RegistrationService;

@RestController
@RequestMapping("/api")
@Validated
public class RegistrationRestController {

	private Logger logger=LoggerFactory.getLogger(RegistrationRestController.class);
	@Autowired
	RegistrationService registrationService;

	@PostMapping("/create-registration")
	public ResponseEntity<String> saveUser(@Valid @RequestBody RegistrationDto registrationDto) {
		logger.debug("REST request successfully : ",registrationDto);
		String registrationTcsPortal = registrationService.registrationTcsPortal(registrationDto);
		return new ResponseEntity<>(registrationTcsPortal, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginPortal loginPortal) {
		logger.debug("REST Login request successfully : ",loginPortal);

		String loginPortal2 = registrationService.loginPortal(loginPortal);
		return new ResponseEntity<String>(loginPortal2,HttpStatus.OK);

	}

}
