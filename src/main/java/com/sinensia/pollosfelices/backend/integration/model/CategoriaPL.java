package com.sinensia.pollosfelices.backend.integration.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CATEGORIAS")
public class CategoriaPL implements Serializable {
	
	@Id
	private Long id;
	
	private String name;
	
	public CategoriaPL() {
		// No args constructor
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CategoriaPL)) {
			return false;
		}
		CategoriaPL other = (CategoriaPL) obj;
		return Objects.equals(id, other.id);
	}
	
}
