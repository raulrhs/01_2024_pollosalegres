package com.sinensia.pollosalegres.backend.integration.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.sinensia.pollosalegres.backend.integration.model.CamareroPL;

@DataJpaTest
@Sql(scripts={"/data/h2/schema_test.sql","/data/h2/data_test.sql"})
class CamareroPLRepositoryTest {

	@Autowired
	private CamareroPLRepository camareroPLRepository;
	
	@Test
	void findByDniTest() {
	
		Optional<CamareroPL> optionalExistente = camareroPLRepository.findByDni("30092765K");
		Optional<CamareroPL> optionalEmpty = camareroPLRepository.findByDni("66666666D");
		
		assertTrue(optionalExistente.isPresent());
		assertEquals(11L, optionalExistente.get().getId());
		assertTrue(optionalEmpty.isEmpty());
	}

	@Test
	void findByNombreLikeIgnoreCaseOrderByIdTest() {
		
		CamareroPL camareroPL1 = new CamareroPL();
		CamareroPL camareroPL2 = new CamareroPL();
		
		camareroPL1.setId(14L);
		camareroPL2.setId(15L);
		
		List<CamareroPL> camarerosPLEsperados = Arrays.asList(camareroPL1, camareroPL2);
		
		List<CamareroPL> camarerosPL = camareroPLRepository.findByNombreLikeIgnoreCase("nA");
		
		assertNotNull(camarerosPL);
		assertEquals(2, camarerosPL.size());
		assertTrue(camarerosPL.containsAll(camarerosPLEsperados));	
	};
	
	@Test
	void existeByDniTest() {
		
		boolean existe1 = camareroPLRepository.existsByDni("30092765K");
		boolean existe2 = camareroPLRepository.existsByDni("66666666D");
		
		assertTrue(existe1);
		assertFalse(existe2);
	}
}
