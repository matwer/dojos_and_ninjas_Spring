package com.shad.dojos_Ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shad.dojos_Ninjas.models.Dojo;
import com.shad.dojos_Ninjas.models.Ninja;
import com.shad.dojos_Ninjas.services.DojoService;
import com.shad.dojos_Ninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaSvc;
	private final DojoService dojoSvc;
	
	public NinjaController(NinjaService ninjaSvc, DojoService dojoSvc) {
		this.ninjaSvc = ninjaSvc;
		this.dojoSvc = dojoSvc;
	}
	
	@RequestMapping("/ninjas/add")
	public String main(@ModelAttribute ("ninja") Ninja n, Model model) {
		List<Dojo> dojos = dojoSvc.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninjas/newNinja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String addNinja(@Valid @ModelAttribute ("ninja") Ninja n, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/newNinja.jsp";
        } else {
        	ninjaSvc.addNinja(n);
			return "redirect:/ninjas/add";
        }
	}
}
