package com.sinensia.pollosfelices.backend.business.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.pollosfelices.backend.business.model.Camarero;

import com.sinensia.pollosfelices.backend.business.model.DatosContacto;
import com.sinensia.pollosfelices.backend.business.model.Direccion;
import com.sinensia.pollosfelices.backend.business.services.CamareroServices;

public class CamareroServicesImpl implements CamareroServices {

	private final Map<Long, Camarero> CAMAREROS_DB = new HashMap<>();
	
	public CamareroServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Camarero camarero) {
		
		if(camarero.getId() != null) {
			throw new IllegalStateException("Para crear un camarero el id ha de ser null");
		}
		
		Long id = System.currentTimeMillis();
		
		camarero.setId(id);
		
		CAMAREROS_DB.put(id, camarero);
		
		return id;
	}

	@Override
	public Optional<Camarero> read(Long id) {
		return Optional.ofNullable(CAMAREROS_DB.get(id));
	}

	@Override
	public Optional<Camarero> read(String dni) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Camarero camarero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		
		boolean existe = CAMAREROS_DB.containsKey(id);
		
		if(!existe) {
			throw new IllegalStateException("EL camarero con id " + id + " no existe. No se puede eliminar.");
		}
		
		CAMAREROS_DB.remove(id);
	}

	@Override
	public List<Camarero> getAll() {
		return new ArrayList<Camarero>(CAMAREROS_DB.values());
	}

	@Override
	public List<Camarero> getByNombreLikeIgnoreCase(String texto) {
		
		return CAMAREROS_DB.values().stream()
				.filter(x -> x.getNombre().toUpperCase().equals(texto.toUpperCase()))
				.toList();	
	}

	@Override
	public int getNumeroTotalCamareros() {
		return CAMAREROS_DB.size();
	}
	
	// *************************************************
	//
	// Private Methods
	//
	// *************************************************

	private void init() {
		
		Camarero c1 = new Camarero();
		Camarero c2 = new Camarero();
		
		Direccion direccion1 = new Direccion();
		Direccion direccion2 = new Direccion();
		
		DatosContacto datosContacto1 = new DatosContacto();
		DatosContacto datosContacto2 = new DatosContacto();
		
		direccion1.setDireccion("c/ Padilla, 230 ático 2");
		direccion1.setPoblacion("Barcelona");
		direccion1.setCodigoPostal("80934");
		direccion1.setProvincia("Barcelona");
		direccion1.setPais("España");
		datosContacto1.setTelefono("932218772");
		datosContacto1.setFax(null);
		datosContacto1.setEmail("pablofer334@hotmail.com");
		
		direccion2.setDireccion("Avda. Pintor Garriño, 230-232");
		direccion2.setPoblacion("Móstoles");
		direccion2.setCodigoPostal("91002");
		direccion2.setProvincia("Madrid");
		direccion2.setPais("España");
		datosContacto2.setTelefono("912293444");
		datosContacto2.setFax(null);
		datosContacto2.setEmail("annabado@gmail.com");
		
		c1.setId(100L);
		c1.setDni("27884178R");
		c1.setNombre("Pablo");
		c1.setApellido1("Fernández");
		c1.setApellido2("Borlán");
		c1.setDireccion(direccion1);
		c1.setDatosContacto(datosContacto1);
		c1.setLicenciaManipuladorAlimentos("LMA4998111253R");
		
		c2.setId(101L);
		c2.setDni("30092123H");
		c2.setNombre("Ana");
		c2.setApellido1("Badosa");
		c2.setApellido2("Domingo");
		c2.setDireccion(direccion2);
		c2.setDatosContacto(datosContacto2);
		c2.setLicenciaManipuladorAlimentos("LMA9000238712F");
		
		CAMAREROS_DB.put(c1.getId(), c1);
		CAMAREROS_DB.put(c2.getId(), c2);
		
	}

}
