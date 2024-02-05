package com.sinensia.pollosalegres.backend.integration.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.pollosalegres.backend.integration.model.CamareroPL;
import com.sinensia.pollosalegres.backend.integration.model.dtos.CamareroPLDTO1;

public interface CamareroPLRepository extends JpaRepository<CamareroPL, Long>{

	Optional<CamareroPL> findByDni(String dni);

	@Query("SELECT c FROM CamareroPL c WHERE UPPER(c.nombre) LIKE UPPER(CONCAT('%',:nombre,'%'))")
	List<CamareroPL> findByNombreLikeIgnoreCase(String nombre);

	boolean existsByDni(String dni);
	
	@Query("SELECT new com.sinensia.pollosalegres.backend.integration.model.dtos.CamareroPLDTO1(c.id, c.nombre, c.apellido1, c.apellido2, c.licenciaManipuladorAlimentos) FROM CamareroPL c")
	List<CamareroPLDTO1> findAllDTO1();
	
	// ******************************************************************************
	// Demos de JPQL que NO SE UTILIZAN!!!! A modo de showcase   NO REQUIERN TESTING
	// ******************************************************************************
	
	@Query("SELECT c FROM CamareroPL c ORDER BY c.id DESC")
	List<CamareroPL> getAll();
	
	@Query("SELECT c FROM CamareroPL c WHERE c.apellido2 IS NULL")
	List<CamareroPL> getApellido2Null();
	
	@Query("SELECT c FROM CamareroPL c WHERE LENGTH(c.apellido1) >= :minSize")
	List<CamareroPL> getApellido1Largo(Integer minSize);
	
	@Query("SELECT c.nombre, c.apellido1, c.apellido2, c.licenciaManipuladorAlimentos FROM CamareroPL c")
	List<Object[]> getTabla1();
	
	@Query("SELECT CONCAT(c.nombre,' ',c.apellido1), LENGTH(CONCAT(c.nombre,c.apellido1)) FROM CamareroPL c")
	List<Object[]> getTabla2();
	
	@Query("SELECT c.direccion.provincia, COUNT(c) FROM CamareroPL c GROUP BY c.direccion.provincia")
	List<Object[]> getTabla3();
	
	// Se pueden hacer queries nativas (SQL puro y duro)
	
	@Query(value = "SELECT C.CODIGO_CAMARERO,                "
			+ "            C.LICENCIA_MANIPULADOR_ALIMENTOS, "
			+ "            P.NOMBRE,                         "
			+ "            P.APELLIDO1,                      "
			+ "            P.APELLIDO2                       "
			+ "       FROM CAMAREROS C JOIN PERSONAS P ON C.CODIGO_CAMARERO = P.CODIGO", nativeQuery = true)
	List<Object[]> getTabla4();
	 
	// Consulta de modificacion (UPDATE, INSERT, DELETE)
	
	@Modifying
	@Query("UPDATE CamareroPL c SET c.nombre = UPPER(c.nombre)")
	void mayusculizarNombres();
	
}
