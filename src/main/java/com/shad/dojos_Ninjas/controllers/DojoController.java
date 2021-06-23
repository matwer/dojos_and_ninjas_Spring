/**
 * @author Matthew Werner
 *
 */

package com.shad.dojos_Ninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shad.dojos_Ninjas.models.Dojo;
import com.shad.dojos_Ninjas.models.Ninja;
import com.shad.dojos_Ninjas.services.DojoService;
import com.shad.dojos_Ninjas.services.NinjaService;


@Controller
public class DojoController {
	private final DojoService dojoSvc;
	private final NinjaService ninjaSvc;
	
	public DojoController(DojoService dojoSvc, NinjaService ninjaSvc) {
		this.dojoSvc = dojoSvc;
		this.ninjaSvc = ninjaSvc;
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/dojos/add";
	}
	
	@RequestMapping("/dojos/add")
	public String main(@ModelAttribute ("dojo") Dojo d) {
		return "/dojos/newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute ("dojo") Dojo d, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/newDojo.jsp";
        } else {
        	dojoSvc.addEntry(d);
			return "redirect:/dojos/add";
        }
	}
	
	@RequestMapping("/dojos/{id}")
	public String getNinjasByDojo(@PathVariable("id") Long id, @ModelAttribute("ninjaByDojo") Ninja n, Model model) {
		Dojo d = dojoSvc.getById(id);
		// get the dojo
		model.addAttribute("dojo", d);
		// get a list of ninjas in the dojo and pass it in using the Model model
		model.addAttribute("ninjaList", d.getNinjas());
		
		return "/ninjas/ninjasInDojo.jsp";
	}
	
}
