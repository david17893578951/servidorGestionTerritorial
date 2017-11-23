package gestionTerritorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestionTerritorial.model.Catalogo;
import gestionTerritorial.repository.CatalogoRepo;

@RestController
@RequestMapping("/catalogo")
@CrossOrigin
public class CatalogoController {

	@Autowired
	private CatalogoRepo repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Catalogo> getAllCatalogo(){
		return this.repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/lista/{padreclave}")
	public List<Catalogo> getListaItem(@PathVariable("padreclave") String padreclave){
		return this.repo.getListaItem(padreclave);
	}
	
	
	
	
	
}
