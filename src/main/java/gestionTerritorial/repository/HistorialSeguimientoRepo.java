package gestionTerritorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestionTerritorial.model.HistorialSeguimiento;

@Repository
public interface HistorialSeguimientoRepo extends JpaRepository<HistorialSeguimiento, Integer> {

	@Modifying
	@Query("SELECT h FROM HistorialSeguimiento h where h.gtrAsignacionSuelo.id=?")
	public List<HistorialSeguimiento> getListaItem(@Param("id") Integer id);

	@Modifying
	@Transactional
	@Query(value = "update gtr_historial_seguimiento set hse_estado='63' where sue_id=? and hse_estado='62'", nativeQuery = true)
	public int getInactivos(@Param("nroId") int nroId);

}
