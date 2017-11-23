package gestionTerritorial.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionTerritorial.model.FuenteHidrica;

@Repository
public interface FuenteHidricaRepo extends JpaRepository<FuenteHidrica, Integer>{
	
	@Modifying
	@Query("SELECT f FROM FuenteHidrica f where f.gtrAsignacionSuelo.id=:nroId")
	public List<FuenteHidrica> getListaItem1(@Param("nroId") int nroId);	
	
	@Modifying
	@Query("SELECT f FROM FuenteHidrica f where f.gtrAsignacionSuelo.id=:nroIdd and f.estado='59'")
	public List<FuenteHidrica> getFuenteActiva(@Param("nroIdd") Integer nroIdd);
	
	@Modifying
	@Transactional
	@Query(value="update gtr_fuente_hidrica set hid_estado='60' where sue_id=? and hid_estado='59'", nativeQuery=true)
	public int getInactivos(@Param("nroId") int nroId);
	
}
