package com.sinensia.pollosalegres.backend.business.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinensia.pollosalegres.backend.business.model.Categoria;
import com.sinensia.pollosalegres.backend.business.model.Producto;
import com.sinensia.pollosalegres.backend.business.model.dtos.EstadisticaDTO1;
import com.sinensia.pollosalegres.backend.business.model.dtos.EstadisticaDTO2;
import com.sinensia.pollosalegres.backend.business.services.ProductoServices;
import com.sinensia.pollosalegres.backend.integration.model.ProductoPL;
import com.sinensia.pollosalegres.backend.integration.repositories.ProductoPLRepository;

@Service
public class ProductoServicesImpl implements ProductoServices {

	private ProductoPLRepository productoPLRepository;
	private DozerBeanMapper mapper;
	
	public ProductoServicesImpl(ProductoPLRepository productoPLRepository, DozerBeanMapper mapper) {
		this.productoPLRepository = productoPLRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public Long create(Producto producto) {
		
		if(producto.getCodigo() != null) {
			throw new IllegalStateException("Para crear un producto el codigo ha de ser null");
		}
		
		ProductoPL productoPL = mapper.map(producto, ProductoPL.class);
		productoPL.setCodigo(System.currentTimeMillis());
		
		return productoPLRepository.save(productoPL).getCodigo();
		
	}

	@Override
	public Optional<Producto> read(Long codigo) {
		
		Optional<ProductoPL> optional = productoPLRepository.findById(codigo);
		
		Producto producto = null;
		
		if(optional.isPresent()) {
			producto = mapper.map(optional.get(), Producto.class);
		}
		
		return Optional.ofNullable(producto);
	}

	@Transactional
	@Override
	public void update(Producto producto) {
		
		Long codigo = producto.getCodigo();

		if(codigo == null) {
			throw new IllegalStateException("No se puede actualizar un producto con codigo null");
		}

		boolean existe = productoPLRepository.existsById(codigo);
		
		if(!existe) {
			throw new IllegalStateException("El producto con codigo " + codigo + " no existe. No se puede actualizar");
		}

		productoPLRepository.save(mapper.map(producto, ProductoPL.class));
		
	}

	@Override
	public List<Producto> getAll() {

		return productoPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Producto.class))
				.toList();
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getDescatalogados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getByCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoPLRepository.count();
	}

	@Override
	public void variarPrecio(List<Producto> productos, double porcentaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void variarPrecio(long[] codigos, double porcentaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Categoria, Integer> getEstadisticaNumeroProductoPorCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Categoria, Double> getEstadisticaPrecioMedioProductosPorCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadisticaDTO1> getEstadisticasDTO1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadisticaDTO2> getEstadisticasDTO2() {
		// TODO Auto-generated method stub
		return null;
	}

}
