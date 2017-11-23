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

import gestionTerritorial.model.EntregablesContrato;
import gestionTerritorial.repository.EntregablesContratoRepo;

@RestController
@RequestMapping("/entregable")
@CrossOrigin
public class EntregableContratoController {

	@Autowired
	private EntregablesContratoRepo repo;
	
	@RequestMapping(method=RequestMethod.GET,value = "/findentregale/{id}")
	public List<EntregablesContrato> getEntregabe(@PathVariable("id") Integer id){		
		return this.repo.getListaItem(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public EntregablesContrato insertEntregableContrato(@RequestBody @Valid EntregablesContrato admin, Errors errors) {
		System.out.println("Entro.");
		if (errors.hasErrors()) {
			System.out.println("El Entregable del contrato no es invalido");
			//return admin;
		}
		repo.getInactivos(admin.getGtrContratoAsignacion().getId());
		return this.repo.save(admin);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/edit")
	public EntregablesContrato editAdministradorContrato(@RequestBody @Valid EntregablesContrato admin,Errors errors){
		if (errors.hasErrors()) {
			System.out.println("El Entregable del contrato no es invalido");
		}
		repo.getInactivos(admin.getGtrContratoAsignacion().getId());	
		return this.repo.save(admin);
	}
	
	
}
