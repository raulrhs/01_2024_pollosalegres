package com.sinensia.pollosfelices.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinensia.pollosfelices.backend.business.model.Camarero;
import com.sinensia.pollosfelices.backend.business.services.CamareroServices;
import com.sinensia.pollosfelices.backend.integration.model.CamareroPL;
import com.sinensia.pollosfelices.backend.integration.repositories.CamareroPLRepository;

@Service
public class CamareroServicesImpl implements CamareroServices {

	private CamareroPLRepository camareroPLRepository;
	private DozerBeanMapper mapper;
	
	public CamareroServicesImpl(CamareroPLRepository camareroPLRepository, DozerBeanMapper mapper) {
		this.camareroPLRepository = camareroPLRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public Long create(Camarero camarero) {
		
		if(camarero.getId() != null) {
			throw new IllegalStateException("Para crear un camarero el id ha de ser null");
		}
		
		// TODO Comprobar si ya existe un camarero con el mismo DNI
		// Hemos de incluir el DNI en el mensaje de error?
		
		boolean existeDni = false;
		
		if(existeDni) {
			throw new IllegalStateException("Ya existe un camarero con ese dni");
		}
		
		CamareroPL camareroPL = mapper.map(camarero, CamareroPL.class);
		camareroPL.setId(System.currentTimeMillis());
		
		return camareroPLRepository.save(camareroPL).getId();
	}

	@Override
	public Optional<Camarero> read(Long id) {

		Optional<CamareroPL> optional = camareroPLRepository.findById(id);
		
		Camarero camarero = null;
		
		if(optional.isPresent()) {
			camarero = mapper.map(optional.get(), Camarero.class);
		}
		
		return Optional.ofNullable(camarero);	
	}

	@Override
	public Optional<Camarero> read(String dni) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Transactional
	@Override
	public void update(Camarero camarero) {
		
		// TODO Probar con Postman a ver que pasa con la licencia...
		
		// TODO Mostrar la magia de la transaccion y el contexto de persistencia.
		
		Long id = camarero.getId();

		if(id == null) {
			throw new IllegalStateException("No se puede actualizar un camarero con id null");
		}

		boolean existe = camareroPLRepository.existsById(id);

		if(!existe) {
			throw new IllegalStateException("El camarero con id " + id + " no existe. No se puede actualizar");
		}

		camareroPLRepository.save(mapper.map(camarero, CamareroPL.class));
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		camareroPLRepository.deleteById(id);
	}

	@Override
	public List<Camarero> getAll() {
		
		return camareroPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Camarero.class))
				.toList();
	}

	@Override
	public List<Camarero> getByNombreLikeIgnoreCase(String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalCamareros() {
		return (int) camareroPLRepository.count();
	}

}
