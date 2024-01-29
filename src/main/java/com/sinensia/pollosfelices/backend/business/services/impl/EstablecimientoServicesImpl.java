package com.sinensia.pollosfelices.backend.business.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.pollosfelices.backend.business.model.DatosContacto;
import com.sinensia.pollosfelices.backend.business.model.Direccion;
import com.sinensia.pollosfelices.backend.business.model.Establecimiento;
import com.sinensia.pollosfelices.backend.business.services.EstablecimientoServices;

@Service
public class EstablecimientoServicesImpl implements EstablecimientoServices {

	private final Map<Long, Establecimiento> ESTABLECIMIENTOS_DB = new HashMap<>();
	
	public EstablecimientoServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Establecimiento establecimiento) {
		
		if(establecimiento.getCodigo() != null) {
			throw new IllegalStateException("Para crear un establecimiento el codigo ha de ser null");
		}
		
		Long codigo = System.currentTimeMillis();
		
		establecimiento.setCodigo(codigo);
		
		ESTABLECIMIENTOS_DB.put(codigo, establecimiento);
		
		if(Math.random() > 0) {
			throw new ClassCastException();
		}
		
		return codigo;
	}

	@Override
	public Optional<Establecimiento> read(Long codigo) {
		return Optional.ofNullable(ESTABLECIMIENTOS_DB.get(codigo));
	}

	@Override
	public List<Establecimiento> getAll() {
		return new ArrayList<>(ESTABLECIMIENTOS_DB.values());
	}
	
	// *************************************************
	//
	// Private Methods
	//
	// *************************************************
	
	private void init() {
		
		Establecimiento establecimiento1 = new Establecimiento();
		Establecimiento establecimiento2 = new Establecimiento();
		
		establecimiento1.setCodigo(100L);
		establecimiento2.setCodigo(101L);
		
		DatosContacto datosContacto1 = new DatosContacto();
		DatosContacto datosContacto2 = new DatosContacto();
		
		Direccion direccion1 = new Direccion();
		Direccion direccion2 = new Direccion();
		
		datosContacto1.setTelefono("91 220 34 43");
		datosContacto1.setFax("91 220 24 55");
		datosContacto1.setEmail("vaguada@pollosfelices.com");
		
		datosContacto2.setTelefono("93 231 66 56");
		datosContacto2.setFax(null);
		datosContacto2.setEmail("granvia2@pollosfelices.com");
		
		direccion1.setDireccion("Avda. Monforte de Lemos, 36");
		direccion1.setPoblacion("Fuencarral");
		direccion1.setCodigoPostal("28029");
		direccion1.setProvincia("Madrid");
		direccion1.setPais("España");
		
		direccion2.setDireccion("Avda. de la Gran Via de l'Hospitalet, 75");
		direccion2.setPoblacion("L'Hospitalet de Llobregat");
		direccion2.setCodigoPostal("08908");
		direccion2.setProvincia("Barcelona");
		direccion2.setPais("España");
		
		establecimiento1.setDatosContacto(datosContacto1);	
		establecimiento2.setDatosContacto(datosContacto2);
		establecimiento1.setDireccion(direccion1);
		establecimiento2.setDireccion(direccion2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fecha1 = null;
		Date fecha2 = null;
		
		try {
			fecha1 = sdf.parse("14/04/2005");
			fecha2 = sdf.parse("24/11/1999");
		} catch (ParseException e) {
			
		}
	
		establecimiento1.setFechaInauguracion(fecha1);
		establecimiento2.setFechaInauguracion(fecha2);
		
		establecimiento1.setNombreComercial("Pollos Felices - La Vaguada");
		establecimiento2.setNombreComercial("Pollos Felices - Granvia  2");
		
		ESTABLECIMIENTOS_DB.put(establecimiento1.getCodigo(), establecimiento1);
		ESTABLECIMIENTOS_DB.put(establecimiento2.getCodigo(), establecimiento2);
		
	}

}
