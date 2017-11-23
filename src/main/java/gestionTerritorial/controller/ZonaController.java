package gestionTerritorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestionTerritorial.model.Zona;
import gestionTerritorial.repository.ZonaRepo;

@RestController
@RequestMapping("/zona")
@CrossOrigin
public class ZonaController {
	@Autowired
	private ZonaRepo repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Zona> getAllZonas() {
		return this.repo.findAll();
	}

}