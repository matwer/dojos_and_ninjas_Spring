package com.shad.dojos_Ninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shad.dojos_Ninjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	/**
	 * return all Licenses 
	 */
	List<Ninja> findAll();
	
	// List<Ninja> findNinjasByDojoId();
}
