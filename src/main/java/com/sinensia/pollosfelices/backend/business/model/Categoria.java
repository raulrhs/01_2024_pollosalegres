package com.sinensia.pollosfelices.backend.business.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CATEGORIAS")
public class Categoria implements Serializable {
	
	@Id
	private Long id;
	
	private String nombre;
	
	public Categoria() {
		// No args constructor
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		if (!(obj instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
}
