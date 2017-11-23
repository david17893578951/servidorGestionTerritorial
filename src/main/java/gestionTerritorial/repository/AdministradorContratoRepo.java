package gestionTerritorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionTerritorial.model.AdministradorContrato;

@Repository
public interface AdministradorContratoRepo extends JpaRepository<AdministradorContrato, Integer> {

	@Modifying
	@Query("SELECT a FROM AdministradorContrato a where a.gtrContratoAsignacion.id=?")
	public List<AdministradorContrato> getListaItem(@Param("id") Integer id);	
	
	@Modifying
	@Transactional
	@Query(value="update gtr_administrador_contrato set adc_estado='57' where cas_id=? and adc_estado='56'", nativeQuery=true)
	public int getInactivos(@Param("nroId") int nroId);
	
	
	
}
