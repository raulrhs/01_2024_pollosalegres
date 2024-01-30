package com.sinensia.pollosfelices.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinensia.pollosfelices.backend.business.model.Camarero;
import com.sinensia.pollosfelices.backend.business.model.DatosContacto;
import com.sinensia.pollosfelices.backend.business.model.Direccion;
import com.sinensia.pollosfelices.backend.business.services.CamareroServices;

@WebMvcTest(value = CamareroController.class)
public class CamareroControllerTest {

	@Autowired
	private MockMvc miniPostman;
	
	@Autowired
	private ObjectMapper objectMapper;
	
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

		MvcResult respuesta = miniPostman.perform(get("/camareros")).andExpect(status().isOk()).andReturn();

		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String responseBodyEsperada = objectMapper.writeValueAsString(camareros);

		assertThat(responseBody).isEqualToIgnoringWhitespace(responseBodyEsperada);

	}

	@Test
	void solicitamos_camarero_EXISTINTE_a_partir_de_su_id() throws Exception{
		
		when(camareroServices.read(101L)).thenReturn(Optional.of(camarero2));
		
		
		MvcResult respuesta = miniPostman.perform(get("/camareros/101"))
											.andExpect(status().isOk())
											.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String responseBodyEsperada = objectMapper.writeValueAsString(camarero2);
		
		assertThat(responseBody).isEqualToIgnoringWhitespace(responseBodyEsperada);
	}
	
	@Test
	void solicitamos_eliminar_camarero_a_partir_de_su_id_OK() throws Exception{
		
	    String requestBody = objectMapper.writeValueAsString(101L);

	    MvcResult respuesta = miniPostman.perform(delete("/camareros/101")
	    		.content(requestBody).contentType("application/json"))
	            .andExpect(status().isNoContent())
	            .andReturn();

	    String responseBody = (String.valueOf(respuesta.getResponse().getStatus()));
	    String responseBodyEsperada = objectMapper.writeValueAsString(204);

	    assertThat(responseBody).isEqualToIgnoringWhitespace(responseBodyEsperada);
	}
	
	@Test
	@Disabled
	void solicitamos_eliminar_camarero_a_partir_de_su_id_ERROR() throws Exception{
		//TODO
		fail("Not implemented yet");
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
