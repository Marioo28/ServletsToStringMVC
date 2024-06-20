package com.fdm.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.model.Piesa;
import com.fdm.service.PiesaService;

@Controller
public class PiesaController {

	private final PiesaService piesaService;

	@Autowired
	public PiesaController(PiesaService piesaService) {
		this.piesaService = piesaService;
	}

	@RequestMapping("/add-piesa")
	public String addPiesa() {
		return "addPiesa";
	}

	@RequestMapping("/piesa")
	public ModelAndView createPiece( @RequestParam("nume") String nume,
			@RequestParam("categorie") String categorie, @RequestParam("stoc") int stoc) {

		Piesa piesa = new Piesa(nume, categorie, stoc);
		piesaService.addPiesa(piesa);

		Set<Piesa> piese = piesaService.getAllPieces();
		ModelAndView mv = new ModelAndView();
		mv.addObject("pieces", piese);
		mv.addObject("message", "Piesa adaugata");
		mv.setViewName("piese");

		return mv;
	}

	@RequestMapping("/update-stoc")
	public ModelAndView getPiesaForm(@RequestParam("id") int id) {
		Piesa p = piesaService.getPiesaById(id);

		ModelAndView mv = new ModelAndView();
		mv.addObject("piesa", p);
		mv.setViewName("update-piesa");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update-stoc")
	public ModelAndView updatePesa(@RequestParam("id") int id, @RequestParam("newStoc") int newStoc) {
		Piesa piesa = piesaService.getPiesaById(id);
		int oldStoc = piesa.getStoc();

		if (newStoc < oldStoc) {
			if (newStoc <= 0) {
				piesa.setStoc(0);
			} else {
				piesa.setStoc(newStoc);
			}
		} else {
			piesa.setStoc(newStoc);
		}

		piesaService.updatePiesa(piesa);

		Set<Piesa> piese = piesaService.getAllPieces();
		ModelAndView mv = new ModelAndView();
		mv.addObject("pieces", piese);
		mv.addObject("message", "Stoc piesa actualizat");
		mv.setViewName("piese");

		return mv;
	}

	@RequestMapping("/delete-piesa")
	public ModelAndView deletePiesa(@RequestParam("id") int id) {
		piesaService.deletePiesaById(id);
		Set<Piesa> piese = piesaService.getAllPieces();

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Piesa stearsa");
		mv.addObject("pieces", piese);
		mv.setViewName("piese");

		return mv;
	}

	@RequestMapping("/piese")
	public ModelAndView getAllPieces() {

		Set<Piesa> piese = piesaService.getAllPieces();
		ModelAndView mv = new ModelAndView();
		mv.addObject("pieces", piese);
		mv.setViewName("piese");

		return mv;
	}
}
