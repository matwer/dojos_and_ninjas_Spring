package com.shad.dojos_Ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shad.dojos_Ninjas.models.Ninja;
import com.shad.dojos_Ninjas.repos.NinjaRepo;


@Service
public class NinjaService {
	// instantiate a new repository
	private final NinjaRepo ninjaRepo;
	
	// set up a constructor for the service
	public NinjaService (NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	/**
	 * returns all entries from the repository
	 **/
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    
	/**
	 * adds a new entry to the repository
	 **/
    public Ninja addNinja(Ninja n) {
        return ninjaRepo.save(n);
    }
    
	/**
	 * findNinjasByLocation
	 **/
    public List<Ninja> getNinjaByDojo() {
    	return ninjaRepo.findAll();
    }

}
