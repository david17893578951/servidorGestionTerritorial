package gestionTerritorial.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionTerritorial.model.Zona;

@Repository
public interface ZonaRepo extends JpaRepository<Zona, Integer>{


}
