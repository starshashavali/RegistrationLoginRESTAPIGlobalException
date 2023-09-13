package com.emp.gis.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.gis.domain.Registration;
import com.emp.gis.dto.LoginPortal;
import com.emp.gis.dto.RegistrationDto;
import com.emp.gis.exception.AuthenticationException;
import com.emp.gis.exception.DuplicateEmailException;
import com.emp.gis.repo.RegistrationRepo;
import com.emp.gis.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	RegistrationRepo registrationRepo;

	@Override
	public String registrationTcsPortal(RegistrationDto registrationDto) {
	    logger.debug("Register method call to save user data" + registrationDto);
	    Optional<Registration> findByEmail = registrationRepo.findByEmail(registrationDto.getEmail());

	    if (findByEmail.isPresent()) {
	        throw new DuplicateEmailException("Duplicate email");
	    }

	    Registration entity = new Registration();
	    BeanUtils.copyProperties(registrationDto, entity);
	    registrationRepo.save(entity);

	    return "success";
	}


	@Override
	public String loginPortal(LoginPortal loginPortal) {
	    logger.debug("Login method call to user data" + loginPortal);

	    Optional<Registration> findByEmail = registrationRepo.findByEmail(loginPortal.getEmail());

	    if (findByEmail.isPresent()) {
	        Registration registration = findByEmail.get();
	        if (registration.getEmail().equalsIgnoreCase(loginPortal.getEmail())
	                && registration.getPwd().equals(loginPortal.getPwd())) {
	            return "successfully login";
	        }
	    }
	    throw new AuthenticationException("Login failed");

	   
	}


}
