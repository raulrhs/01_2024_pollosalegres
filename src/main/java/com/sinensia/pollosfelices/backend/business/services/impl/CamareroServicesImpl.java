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
		
		return CAMAREROS_DB.values().stream()
				.filter(x -> x.getDni().equals(dni))
				.findFirst();
	}

	@Override
	public void update(Camarero camarero) {
		
		Long id = camarero.getId();
		
		if(id == null) {
			throw new IllegalStateException("No se puede actualizar un camarero con id null");
		}
		
		boolean existe = CAMAREROS_DB.containsKey(id);
		
		if(!existe) {
			throw new IllegalStateException("El camarero con id " + id + " no existe. No se puede actualizar");
		}
		
		CAMAREROS_DB.replace(id, camarero);
		
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
		Camarero c3 = new Camarero();
		
		Direccion direccion1 = new Direccion();
		Direccion direccion2 = new Direccion();
		Direccion direccion3 = new Direccion();
		
		DatosContacto datosContacto1 = new DatosContacto();
		DatosContacto datosContacto2 = new DatosContacto();
		DatosContacto datosContacto3 = new DatosContacto();
		
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
		
		direccion3.setDireccion("c/ Pez Volador, 2 4º 2ª");
		direccion3.setPoblacion("Madrid");
		direccion3.setCodigoPostal("91240");
		direccion3.setProvincia("Madrid");
		direccion3.setPais("España");
		datosContacto3.setTelefono("912547821");
		datosContacto3.setFax(null);
		datosContacto3.setEmail("pacoort@gmail.com");
		
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
		
		c3.setId(102L);
		c3.setDni("45099812W");
		c3.setNombre("Francisco Javier");
		c3.setApellido1("Ort");
		c3.setApellido2("Montcunill");
		c3.setDireccion(direccion3);
		c3.setDatosContacto(datosContacto3);
		c3.setLicenciaManipuladorAlimentos("LMA9033289712G");
		
		CAMAREROS_DB.put(c1.getId(), c1);
		CAMAREROS_DB.put(c2.getId(), c2);
		CAMAREROS_DB.put(c3.getId(), c3);
		
	}

}
