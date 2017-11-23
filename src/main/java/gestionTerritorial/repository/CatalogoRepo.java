package gestionTerritorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gestionTerritorial.model.Catalogo;

@Repository
public interface CatalogoRepo extends JpaRepository<Catalogo, Integer>{
	@Modifying
	@Query("SELECT c FROM Catalogo c where c.clavePadre=?")
	public List<Catalogo> getListaItem(@Param("padreclave") String padreclave);
}