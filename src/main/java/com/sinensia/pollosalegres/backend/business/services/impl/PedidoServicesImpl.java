package com.sinensia.pollosalegres.backend.business.services.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.pollosalegres.backend.business.model.Pedido;
import com.sinensia.pollosalegres.backend.business.services.PedidoServices;
import com.sinensia.pollosalegres.backend.integration.model.PedidoPL;
import com.sinensia.pollosalegres.backend.integration.repositories.PedidoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoServicesImpl implements PedidoServices {

	private PedidoPLRepository pedidoPLRepository;
	private DozerBeanMapper mapper;
	
	public PedidoServicesImpl(PedidoPLRepository pedidoPLRepository, DozerBeanMapper mapper) {
		this.pedidoPLRepository = pedidoPLRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public Long create(Pedido pedido) {
		
		if(pedido.getNumero() != null) {
			throw new IllegalStateException("Para crear un pedido el codigo ha de ser null");
		}
		
		PedidoPL pedidoPL = mapper.map(pedido, PedidoPL.class);
		pedidoPL.setNumero(System.currentTimeMillis());
		
		return pedidoPLRepository.save(pedidoPL).getNumero();
	}

	@Override
	public Optional<Pedido> read(Long numero) {
		
		Optional<PedidoPL> optional = pedidoPLRepository.findById(numero);
		
		Pedido pedido = null;
		
		if(optional.isPresent()) {
			pedido = mapper.map(optional.get(), Pedido.class);
		}
		
		return Optional.ofNullable(pedido);
	}

	@Override
	public void update(Long numerPedido, Map<String, Object> atributos) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void update(Pedido pedido) {
		Long numero = pedido.getNumero();

		if(numero == null) {
			throw new IllegalStateException("No se puede actualizar un pedido con codigo null");
		}

		boolean existe = pedidoPLRepository.existsById(numero);
		
		if(!existe) {
			throw new IllegalStateException("El pedido con numero " + numero + " no existe. No se puede actualizar");
		}

		pedidoPLRepository.save(mapper.map(pedido, PedidoPL.class));
	}

	@Override
	public List<Pedido> getAll() {
		
		return pedidoPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Pedido.class))
				.toList();
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
