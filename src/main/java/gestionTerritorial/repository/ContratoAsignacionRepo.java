package gestionTerritorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionTerritorial.model.ContratoAsignacion;


@Repository
public interface ContratoAsignacionRepo extends JpaRepository<ContratoAsignacion, Integer> {

	@Modifying
	@Query("SELECT c FROM ContratoAsignacion c where c.gtrAsignacionSuelo.id=?")
	public List<ContratoAsignacion> getListaItem(@Param("id") Integer id);
	
	@Modifying
	@Query("SELECT c FROM ContratoAsignacion c where c.gtrAsignacionSuelo.id=? and c.estado='52'")
	public List<ContratoAsignacion> getContratoporasignacion(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value="update gtr_contrato_asignacion set cas_estado='53' where sue_id=? and cas_estado='52'", nativeQuery=true)
	public int getInactivos(@Param("nroId") int nroId);
	//update gtr_contrato_asignacion set cas_estado='53' where sue_id='1'
	
	
}
