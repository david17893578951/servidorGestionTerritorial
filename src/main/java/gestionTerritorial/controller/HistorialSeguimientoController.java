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

import gestionTerritorial.model.HistorialSeguimiento;
import gestionTerritorial.repository.HistorialSeguimientoRepo;

@RestController
@RequestMapping("/historial")
@CrossOrigin
public class HistorialSeguimientoController {
	@Autowired
	private HistorialSeguimientoRepo repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<HistorialSeguimiento> getAllAsignacionSuelos() {
		return this.repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/seguimiento/{id}")
	public List<HistorialSeguimiento> getSeguimientobyasignacionsuelo(@PathVariable("id") Integer id) {
		return this.repo.getListaItem(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public HistorialSeguimiento insertHistorial(@RequestBody @Valid HistorialSeguimiento historial, Errors errors) {
		System.out.println("Entro.");
		if (errors.hasErrors()) {
			System.out.println("La historial es invalido");
			return historial;
		}
		repo.getInactivos(historial.getGtrAsignacionSuelo().getId());
		return this.repo.save(historial);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/edit")
	public HistorialSeguimiento editarHistorial(@RequestBody @Valid HistorialSeguimiento historial,Errors errors){
		if (errors.hasErrors()) {
			System.out.println("La Historial no es valida");
		}
		repo.getInactivos(historial.getGtrAsignacionSuelo().getId());
		return this.repo.save(historial);
	}

}
