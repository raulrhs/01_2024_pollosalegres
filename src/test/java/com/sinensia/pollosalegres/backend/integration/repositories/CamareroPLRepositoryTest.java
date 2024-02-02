package com.sinensia.pollosalegres.backend.integration.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql(scripts={"/data/h2/schema.sql","/data/h2/data.sql"})
class CamareroPLRepositoryTest {

	@Autowired
	private CamareroPLRepository camareroPLRepository;
	
	@Test
	void existeByDniTest() {
		
		boolean existe1 = camareroPLRepository.existsByDni("30092765K");
		boolean existe2 = camareroPLRepository.existsByDni("66666666D");
		
		assertTrue(existe1);
		assertFalse(existe2);
	}
}
