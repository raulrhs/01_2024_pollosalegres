package com.sinensia.pollosalegres.backend.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.pollosalegres.backend.integration.model.ProductoPL;

public interface ProductoPLRepository extends JpaRepository<ProductoPL, Long>{

	List<ProductoPL> findByPrecioBetween(double min, double max);
	
	List<ProductoPL> findByFechaAltaBetween(Date desde, Date hasta);
	
	List<ProductoPL> findByDescatalogadoTrue();
	
	List<ProductoPL> findByCategoriaId(Long id);
		
	@Query("UPDATE ProductoPL p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p IN :productos")
	@Modifying
	void variarPrecio(List<ProductoPL> productos, double porcentaje);
	
	@Query("UPDATE ProductoPL p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p.codigo IN :codigos")
	@Modifying
	void variarPrecio(long[] codigos, double porcentaje);

	@Query("SELECT p.categoria, COUNT(p) FROM ProductoPL p GROUP BY p.categoria")
	List<Object[]> getEstadisticaNumeroProductoPorCategoria();
	
	@Query("SELECT p.categoria, AVG(p.precio) FROM ProductoPL p GROUP BY p.categoria")
	List<Object[]> getEstadisticaPrecioMedioProductoPorCategoria();
}
