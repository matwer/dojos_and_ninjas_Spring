package com.shad.dojos_Ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shad.dojos_Ninjas.models.Dojo;
import com.shad.dojos_Ninjas.repos.DojoRepo;

@Service
public class DojoService {
	// instantiate a new repository
	private final DojoRepo dojoRepo;
	
	// set up a constructor for the service
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	/**
	 * returns all entries from the repository
	 **/
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    
	/**
	 * adds a new entry to the repository
	 **/
    public Dojo addEntry(Dojo d) {
        return dojoRepo.save(d);
    }
    
    public Dojo getById(Long id) {
        Optional<Dojo> dojo = dojoRepo.findById(id);
        
        if(dojo.isPresent()) {
            return dojo.get();
        } else {        	
        	return null;
        }

    }
    
}
