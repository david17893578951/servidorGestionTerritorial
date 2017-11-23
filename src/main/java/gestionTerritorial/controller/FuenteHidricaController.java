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

import gestionTerritorial.model.FuenteHidrica;
import gestionTerritorial.repository.FuenteHidricaRepo;

@RestController
@RequestMapping("/fuentehidrica")
@CrossOrigin
public class FuenteHidricaController {
	@Autowired
	private FuenteHidricaRepo repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<FuenteHidrica> getAllFuenteHidricas() {
		return this.repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public FuenteHidrica insertarFuenteHidrica(@RequestBody @Valid FuenteHidrica fuenteh, Errors errors) {
		System.out.println("Entro.");
		if (errors.hasErrors()) {
			System.out.println("La Fuente Hidrica es invalido");
			return fuenteh;
		}
		repo.getInactivos(fuenteh.getGtrAsignacionSuelo().getId());

		return this.repo.save(fuenteh);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/edit")
	public FuenteHidrica editarFuenteHidrica(@RequestBody @Valid FuenteHidrica fuentes, Errors errors) {
		if (errors.hasErrors()) {
			System.out.println("La Fuente Hidrica no es valida");
		}

		repo.getInactivos(fuentes.getGtrAsignacionSuelo().getId());
		return this.repo.save(fuentes);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fuente/{id}")
	public List<FuenteHidrica> getFuentebyasignacionsuelo(@PathVariable("id") Integer id) {
		return this.repo.getListaItem1(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fuente/activa/{id}")
	public List<FuenteHidrica> getFuenteActiva(@PathVariable("id") Integer id) {
		return this.repo.getFuenteActiva(id);
	}
}
