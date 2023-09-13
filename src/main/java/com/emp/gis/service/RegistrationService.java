package com.emp.gis.service;

import com.emp.gis.dto.LoginPortal;
import com.emp.gis.dto.RegistrationDto;

public interface RegistrationService {

	public String registrationTcsPortal(RegistrationDto registrationDto);

	public String loginPortal(LoginPortal loginPortal);

}
