package com.sinensia.pollosalegres.backend.business.services.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.pollosalegres.backend.business.model.Pedido;
import com.sinensia.pollosalegres.backend.business.services.PedidoServices;
import com.sinensia.pollosalegres.backend.integration.repositories.PedidoPLRepository;

@Service
public class PedidoServicesImpl implements PedidoServices {

	private PedidoPLRepository pedidoPLRepository;
	private DozerBeanMapper mapper;
	
	public PedidoServicesImpl(PedidoPLRepository pedidoPLRepository, DozerBeanMapper mapper) {
		this.pedidoPLRepository = pedidoPLRepository;
		this.mapper = mapper;
	}
	
	@Override
	public Long create(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pedido> read(Long numero) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Long numerPedido, Map<String, Object> atributos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void procesar(Long numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entregar(Long numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void servir(Long numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar(Long numero) {
		// TODO Auto-generated method stub
		
	}

}
