package com.sinensia.pollosalegres.backend.presentation.controllers;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;

import com.sinensia.pollosalegres.backend.business.model.Camarero;
import com.sinensia.pollosalegres.backend.business.model.DatosContacto;
import com.sinensia.pollosalegres.backend.business.model.Direccion;
import com.sinensia.pollosalegres.backend.business.services.CamareroServices;
import com.sinensia.pollosalegres.backend.presentation.config.RespuestaError;

@WebMvcTest(value = CamareroController.class)
class CamareroControllerTest extends AbstractControllerTest {

	@MockBean
	private CamareroServices camareroServices;

	private Camarero camarero1;
	private Camarero camarero2;
	private Camarero camarero3;

	@BeforeEach
	void init() {
		initObjects();
	}

	@Test
	void solicitamos_todos_los_camareros() throws Exception {

		List<Camarero> camareros = Arrays.asList(camarero1, camarero2, camarero3);

		when(camareroServices.getAll()).thenReturn(camareros);

		MvcResult respuesta = mockMvc.perform(get("/camareros")).andExpect(status().isOk()).andReturn();

		checkResponseBody(camareros, respuesta);
	}

	@Test
	void solicitamos_camareros_por_nombre() throws Exception {

		List<Camarero> camareros = Arrays.asList(camarero1, camarero2, camarero3);

		when(camareroServices.getByNombreLikeIgnoreCase("a")).thenReturn(camareros);

		MvcResult respuesta = mockMvc.perform(get("/camareros").param("nombre", "a")).andExpect(status().isOk())
				.andReturn();

		checkResponseBody(camareros, respuesta);
	}

	@Test
	void solicitamos_camarero_EXISTINTE_a_partir_de_su_id() throws Exception{
		
		when(camareroServices.read(101L)).thenReturn(Optional.of(camarero2));
		
		MvcResult respuesta = mockMvc.perform(get("/camareros/101"))
										 .andExpect(status().isOk())
										 .andReturn();
		
		checkResponseBody(camarero2, respuesta);
	}

	@Test
	void solicitamos_camarero_NO_EXISTINTE_a_partir_de_su_id() throws Exception{
		
		when(camareroServices.read(101L)).thenReturn(Optional.empty());
		
		MvcResult respuesta = mockMvc.perform(get("/camareros/101"))
										 .andExpect(status().isNotFound())
										 .andReturn();
		
		checkResponseBody(new RespuestaError("No existe el camarero 101"), respuesta);
	}

	@Test
	void creamos_camarero_ok() throws Exception {

		camarero1.setId(null);

		when(camareroServices.create(camarero1)).thenReturn(123456L);

		String requestBody = objectMapper.writeValueAsString(camarero1);

		mockMvc.perform(post("/camareros").content(requestBody).contentType("application/json"))
				.andExpect(status().isCreated())
				.andExpect(header().string("Location", "http://localhost/camareros/123456"));
	}

	@Test
	void creamos_camarero_con_id_NO_null() throws Exception {
		
		when(camareroServices.create(camarero1)).thenThrow(new IllegalStateException("**** EL MENSAJE ****"));
		
		String requestBody = objectMapper.writeValueAsString(camarero1);
		
		MvcResult respuesta = mockMvc.perform(post("/camareros").content(requestBody).contentType("application/json"))
											.andExpect(status().isBadRequest())
											.andReturn();
		
		checkResponseBody(new RespuestaError("**** EL MENSAJE ****"), respuesta);
	}

	@Test
	void actualizamos_camarero_ok() throws Exception {

		String requestBody = objectMapper.writeValueAsString(camarero1);

		mockMvc.perform(put("/camareros/100").content(requestBody).contentType("application/json"))
				.andExpect(status().isNoContent());

		verify(camareroServices, times(1)).update(camarero1);
	}

	@Test
	void actualizamos_camarero_con_id_null() throws Exception {

		doThrow(new IllegalStateException("EL MENSAJE")).when(camareroServices).update(camarero1);

		String requestBody = objectMapper.writeValueAsString(camarero1);

		MvcResult respuesta = mockMvc
				.perform(put("/camareros/100").content(requestBody).contentType("application/json"))
				.andExpect(status().isNotFound()).andReturn();

		verify(camareroServices, times(1)).update(camarero1);

		checkResponseBody(new RespuestaError("EL MENSAJE"), respuesta);
	}

	@Test
	void eliminamos_camarero_EXISTENTE_a_partir_de_su_id() throws Exception {

		mockMvc.perform(delete("/camareros/101")).andExpect(status().isNoContent());

		verify(camareroServices, times(1)).delete(101L);
	}

	@Test
	void eliminamos_camarero_NO_EXISTENTE_a_partir_de_su_id() throws Exception {

		doThrow(new IllegalStateException("EL MENSAJE")).when(camareroServices).delete(101L);

		MvcResult respuesta = mockMvc.perform(delete("/camareros/101")).andExpect(status().isNotFound()).andReturn();

		verify(camareroServices, times(1)).delete(101L);

		checkResponseBody(new RespuestaError("EL MENSAJE"), respuesta);
	}

	// *************************************************
	//
	// Private Methods
	//
	// *************************************************

	private void initObjects() {

		camarero1 = new Camarero();
		camarero2 = new Camarero();
		camarero3 = new Camarero();

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

		camarero1.setId(100L);
		camarero1.setDni("27884178R");
		camarero1.setNombre("Pablo");
		camarero1.setApellido1("Fernández");
		camarero1.setApellido2("Borlán");
		camarero1.setDireccion(direccion1);
		camarero1.setDatosContacto(datosContacto1);
		camarero1.setLicenciaManipuladorAlimentos("LMA4998111253R");

		camarero2.setId(101L);
		camarero2.setDni("30092123H");
		camarero2.setNombre("Ana");
		camarero2.setApellido1("Badosa");
		camarero2.setApellido2("Domingo");
		camarero2.setDireccion(direccion2);
		camarero2.setDatosContacto(datosContacto2);
		camarero2.setLicenciaManipuladorAlimentos("LMA9000238712F");

		camarero3.setId(102L);
		camarero3.setDni("45099812W");
		camarero3.setNombre("Francisco Javier");
		camarero3.setApellido1("Ort");
		camarero3.setApellido2("Montcunill");
		camarero3.setDireccion(direccion3);
		camarero3.setDatosContacto(datosContacto3);
		camarero3.setLicenciaManipuladorAlimentos("LMA9033289712G");
	}

}
