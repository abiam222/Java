package com.guitar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.guitar.model.Manufacturer;

@Repository
@RepositoryRestResource(path="mfgs", collectionResourceRel="mfgs")
//@RepositoryRestResource(path="companies") If I don't like the way Spring Data REST sets the URI
//so instead of Manufacturer it can be whatever I want in the paths variable
@PreAuthorize("hasRole('ROLE_ADMIN')")//This only handles security for this interface
//and only for the properties/functions below
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {
	//These are all methods
	List<Manufacturer> findByFoundedDateBefore(Date date);
	
	List<Manufacturer> findByActiveTrue();
	List<Manufacturer> findByActiveFalse();
	
	List<Manufacturer> getAllThatSellAcoustics(String name);

	// @Override //means this method comes from a parent 
	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	// List<Manufacturer> findAll();

	// @Override
	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	// Page<Manufacturer> findAll(Pageable pageable);

	// @Override
	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	// List<Manufacturer> findAll(Sort sort);

	// @Override
	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	// List<Manufacturer> findAll(Iterable<Long> ids);
}
