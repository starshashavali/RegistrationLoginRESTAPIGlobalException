package com.emp.gis.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.gis.domain.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {

	Optional<Registration> findByEmail(String email);

}
