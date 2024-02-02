package com.sinensia.pollosalegres.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractControllerTest {
	
	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	protected ObjectMapper objectMapper;
	
	protected void checkResponseBody(Object expected, MvcResult response) throws Exception {
		
		String responseBody = response.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String responseBodyEsperada = objectMapper.writeValueAsString(expected);

		assertThat(responseBody).isEqualToIgnoringWhitespace(responseBodyEsperada);	
	}
}
