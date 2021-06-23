package com.shad.dojos_Ninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shad.dojos_Ninjas.models.Dojo;


public interface DojoRepo extends CrudRepository<Dojo, Long> {
	/**
	 * return all Licenses 
	 */
	List<Dojo> findAll();
}
