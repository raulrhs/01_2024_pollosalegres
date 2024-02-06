package com.sinensia.pollosalegres.backend.integration.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.pollosalegres.backend.integration.model.EstadoPedidoPL;
import com.sinensia.pollosalegres.backend.integration.model.PedidoPL;

public interface PedidoPLRepository extends JpaRepository<PedidoPL, Long>{

	@Query("SELECT p.estado FROM PedidoPL p WHERE p.numero = :numero")
	Optional<EstadoPedidoPL> getEstadoByCodigo(Long numero);
	
	@Query("UPDATE PedidoPL p SET p.estado = :estadoPedidoPL WHERE p.numero = :numero")
	@Modifying
	void updateEstado(EstadoPedidoPL estadoPedidoPL, Long numero);
}
