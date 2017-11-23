package gestionTerritorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionTerritorial.model.EntregablesContrato;

@Repository
public interface EntregablesContratoRepo extends JpaRepository<EntregablesContrato, Integer> {
	@Modifying
	@Query("SELECT e FROM EntregablesContrato e where e.gtrContratoAsignacion.id=?")
	public List<EntregablesContrato> getListaItem(@Param("id") Integer id);	
	
	@Modifying
	@Transactional
	@Query(value="update gtr_entregables_contrato set eco_estado='72' where cas_id=? and eco_estado='71'", nativeQuery=true)
	public int getInactivos(@Param("nroId") int nroId);
	
}
