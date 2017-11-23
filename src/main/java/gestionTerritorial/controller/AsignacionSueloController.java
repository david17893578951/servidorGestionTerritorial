package gestionTerritorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestionTerritorial.repository.AsignacionSueloRepo;
import gestionTerritorial.model.AsignacionSuelo;

@RestController
@RequestMapping("/asignacionsuelo")
@CrossOrigin
public class AsignacionSueloController {

	@Autowired
	private AsignacionSueloRepo repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<AsignacionSuelo> getAllAsignacionSuelos() {
		return this.repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public AsignacionSuelo insertAsignacionSuelo(@RequestBody @Valid AsignacionSuelo asignacion, Errors errors) {
		System.out.println("Entro.");
		if (errors.hasErrors()) {
			System.out.println("La Asignacion es invalido");
			return asignacion;
		}
		return this.repo.save(asignacion);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/edit")
	public AsignacionSuelo editarAsignacionSuelo(@RequestBody @Valid AsignacionSuelo asignacion,Errors errors){
		if (errors.hasErrors()) {
			System.out.println("La Asignacion no es valida");
		}
		return this.repo.save(asignacion);
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/lista/{id}")
	public AsignacionSuelo getOneAsignacions(@PathVariable("id") Integer id){		
		return this.repo.findOne(id);
	}


}
