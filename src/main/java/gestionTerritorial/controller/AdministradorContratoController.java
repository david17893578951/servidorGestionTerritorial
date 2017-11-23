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

import gestionTerritorial.model.AdministradorContrato;
import gestionTerritorial.repository.AdministradorContratoRepo;

@RestController
@RequestMapping("/admincontrato")
@CrossOrigin
public class AdministradorContratoController {
	@Autowired 
	private AdministradorContratoRepo repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AdministradorContrato> getAllAdministradorContratos() {
		return this.repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/findcontrato/{id}")
	public List<AdministradorContrato> getAdministrador(@PathVariable("id") Integer id){		
		return this.repo.getListaItem(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public AdministradorContrato insertAdministradorContrato(@RequestBody @Valid AdministradorContrato admin, Errors errors) {
		System.out.println("Entro.");
		if (errors.hasErrors()) {
			System.out.println("La administracion del contrato no es invalido");
			return admin;
		}
		repo.getInactivos(admin.getGtrContratoAsignacion().getId());
		return this.repo.save(admin);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/edit")
	public AdministradorContrato editAdministradorContrato(@RequestBody @Valid AdministradorContrato admin,Errors errors){
		if (errors.hasErrors()) {
			System.out.println("La administracion del contrato no es invalido");
		}
		repo.getInactivos(admin.getGtrContratoAsignacion().getId());	
		return this.repo.save(admin);
	}
}
