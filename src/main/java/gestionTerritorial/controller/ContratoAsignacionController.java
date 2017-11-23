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

import gestionTerritorial.model.ContratoAsignacion;
import gestionTerritorial.repository.ContratoAsignacionRepo;


@RestController
@RequestMapping("/contratoasignacion")
@CrossOrigin
public class ContratoAsignacionController {
	@Autowired
	private ContratoAsignacionRepo repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ContratoAsignacion> getAllContratoAsignacions(){
		return this.repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/contrato/{id}")
	public List<ContratoAsignacion> getContratobyasignacionsuelo(@PathVariable("id") Integer id){		
		return this.repo.getListaItem(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ContratoAsignacion insertContratoAsignacion(@RequestBody @Valid ContratoAsignacion contrato, Errors errors){
		System.out.println("Entro.");
		if (errors.hasErrors()) {
			System.out.println("El contrato es invalido");
			
		}
		repo.getInactivos(contrato.getGtrAsignacionSuelo().getId());
		return this.repo.save(contrato);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/edit")
	public ContratoAsignacion editarContratoAsignacion(@RequestBody @Valid ContratoAsignacion contrato, Errors errors){
		if (errors.hasErrors()) {
			System.out.println("La Asignacion no es valida");
		}
		repo.getInactivos(contrato.getGtrAsignacionSuelo().getId());
		return this.repo.save(contrato);
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/lista/{id}")
	public ContratoAsignacion getOneContratoAsignacion(@PathVariable("id") Integer id){		
		return this.repo.findOne(id);
	}
		
	@RequestMapping(method=RequestMethod.GET,value = "/activos/{id}")
	public List<ContratoAsignacion> getContratoasignacionsuelo(@PathVariable("id") Integer id){		
		return this.repo.getContratoporasignacion(id);
	}
	
}
