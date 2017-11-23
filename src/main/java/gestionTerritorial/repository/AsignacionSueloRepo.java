package gestionTerritorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gestionTerritorial.model.AsignacionSuelo;


@Repository
public interface AsignacionSueloRepo extends JpaRepository<AsignacionSuelo, Integer> {


	@Modifying
	@Query("SELECT a FROM AsignacionSuelo a WHERE a.id=:nroId")
	public List<AsignacionSuelo> getOneAsignacion(@Param("nroId") int nroId);

}
