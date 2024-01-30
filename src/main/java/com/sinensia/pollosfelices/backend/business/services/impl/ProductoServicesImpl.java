package com.sinensia.pollosfelices.backend.business.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.sinensia.pollosfelices.backend.business.model.Categoria;
import com.sinensia.pollosfelices.backend.business.model.Producto;
import com.sinensia.pollosfelices.backend.business.services.ProductoServices;

@Service
public class ProductoServicesImpl implements ProductoServices {

	private final TreeMap<Long, Producto> PRODUCTOS = new TreeMap<>();
	
	public ProductoServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Producto producto) {
		
		if(producto.getCodigo() != null) {
			throw new IllegalStateException("Para crear un producto el codigo ha de ser null");
		}
		
		Long codigo = System.currentTimeMillis();
		
		producto.setCodigo(codigo);
		
		PRODUCTOS.put(codigo, producto);

		return codigo;
	}

	@Override
	public Optional<Producto> read(Long codigo) {
		return Optional.ofNullable(PRODUCTOS.get(codigo));
	}

	@Override
	public void update(Producto producto) {
		
		Long codigo = producto.getCodigo();
		
		if(codigo == null) {
			throw new IllegalStateException("No se puede actualizar un producto con codigo null");
		}
		
		boolean existe = PRODUCTOS.containsKey(codigo);
		
		if(!existe) {
			throw new IllegalStateException("El producto con código " + codigo + " no existe. No se puede actualizar");
		}
		
		PRODUCTOS.replace(codigo, producto);
		
	}

	@Override
	public List<Producto> getAll() {
		return new ArrayList<>(PRODUCTOS.values());
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
	
		return PRODUCTOS.values().stream()
				.filter(x -> x.getPrecio() >= min && x.getPrecio() <= max)
				.toList(); 
	}

	@Override
	public List<Producto> getBetweenDates(Date desde, Date hasta) {
		
		return PRODUCTOS.values().stream()
				.filter(x -> x.getFechaAlta().after(desde) && x.getFechaAlta().before(hasta))
				.toList();
	}

	@Override
	public List<Producto> getDescatalogados() {
		
		return PRODUCTOS.values().stream()
				.filter(x -> x.isDescatalogado())
				.toList(); 
	}

	@Override
	public List<Producto> getByCategoria(Categoria categoria) {
		
		return PRODUCTOS.values().stream()
				.filter(x -> x.getCategoria().equals(categoria))
				.toList();
	}

	@Override
	public int getNumeroTotalProductos() {
		return PRODUCTOS.size();
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
	
	// *************************************************
	//
	// Private Methods
	//
	// *************************************************
	
	private void init() {
		
		Date fecha1 = null;
		Date fecha2 = null;
		Date fecha3 = null;
		Date fecha4 = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			fecha1 = sdf.parse("17/02/2003");
			fecha2 = sdf.parse("09/11/2004");
			fecha3 = sdf.parse("10/12/2004");
			fecha4 = sdf.parse("30/01/2005");
		} catch(ParseException e) {
			// not reached
		}
	
		Categoria c1 = new Categoria();
		Categoria c2 = new Categoria();
		Categoria c3 = new Categoria();
		Categoria c4 = new Categoria();
		
		c1.setId(10L);
		c1.setNombre("TAPA");
		
		c2.setId(11L);
		c2.setNombre("CERVEZA");
		
		c3.setId(12L);
		c3.setNombre("REFRESCO");
		
		c4.setId(13L);
		c4.setNombre("CAFE");
	
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		Producto p3 = new Producto();
		Producto p4 = new Producto();
		Producto p5 = new Producto();
		Producto p6 = new Producto();
		Producto p7 = new Producto();
		Producto p8 = new Producto();
		Producto p9 = new Producto();
		Producto p10 = new Producto();
		
		p1.setCodigo(1000L);
		p1.setNombre("Patatas Bravas");
		p1.setDescripcion("Deliciosas patatas con salsa brava, brava de verdad!");
		p1.setPrecio(6.20);
		p1.setCategoria(c1);
		p1.setFechaAlta(fecha1);
		p1.setDescatalogado(false);
		
		p2.setCodigo(1001L);
		p2.setNombre("Bomba de la Barceloneta");
		p2.setDescripcion("Deliciosas patatas rellenas de carne con salsa brava, brava de verdad!");
		p2.setPrecio(7.10);
		p2.setCategoria(c1);
		p2.setFechaAlta(fecha2);
		p2.setDescatalogado(false);
		
		p3.setCodigo(1002L);
		p3.setNombre("Cocacola Zero");
		p3.setDescripcion("Lata de Cocacola Zero de 33cl");
		p3.setPrecio(2.3);
		p3.setCategoria(c3);
		p3.setFechaAlta(fecha2);
		p3.setDescatalogado(false);
		
		p4.setCodigo(1003L);
		p4.setNombre("Fanta Naranja");
		p4.setDescripcion("Lata de Fanta Naranja de 33cl");
		p4.setPrecio(2.3);
		p4.setCategoria(c3);
		p4.setFechaAlta(fecha2);
		p4.setDescatalogado(false);
		
		p5.setCodigo(1004L);
		p5.setNombre("Café Solo");
		p5.setDescripcion("Café Solo");
		p5.setPrecio(1.9);
		p5.setCategoria(c4);
		p5.setFechaAlta(fecha2);
		p5.setDescatalogado(false);
		
		p6.setCodigo(1005L);
		p6.setNombre("Café Solo Descafeinado");
		p6.setDescripcion("Café Solo Descafeinado");
		p6.setPrecio(2.2);
		p6.setCategoria(c4);
		p6.setFechaAlta(fecha2);
		p6.setDescatalogado(false);
		
		p7.setCodigo(1006L);
		p7.setNombre("Café Americano");
		p7.setDescripcion("Café Americano");
		p7.setPrecio(2.45);
		p7.setCategoria(c4);
		p7.setFechaAlta(fecha3);
		p7.setDescatalogado(false);
		
		p8.setCodigo(1006L);
		p8.setNombre("Cerveza Cruzcampo");
		p8.setDescripcion("Botellín de cerveza Cruzcampo");
		p8.setPrecio(3.10);
		p8.setCategoria(c2);
		p8.setFechaAlta(fecha4);
		p8.setDescatalogado(true);
		
		p9.setCodigo(1006L);
		p9.setNombre("Cerveza Moritz");
		p9.setDescripcion("La cerveza oficial de Barcelona");
		p9.setPrecio(3.30);
		p9.setCategoria(c2);
		p9.setFechaAlta(fecha4);
		p9.setDescatalogado(false);
		
		p10.setCodigo(1007L);
		p10.setNombre("Cerveza San Miguel");
		p10.setDescripcion("Botellín de cerveza San Miguel");
		p10.setPrecio(3.30);
		p10.setCategoria(c2);
		p10.setFechaAlta(fecha4);
		p10.setDescatalogado(false);
		
		PRODUCTOS.put(p1.getCodigo(), p1);
		PRODUCTOS.put(p2.getCodigo(), p2);
		PRODUCTOS.put(p3.getCodigo(), p3);
		PRODUCTOS.put(p4.getCodigo(), p4);
		PRODUCTOS.put(p5.getCodigo(), p5);
		PRODUCTOS.put(p6.getCodigo(), p6);
		PRODUCTOS.put(p7.getCodigo(), p7);
		PRODUCTOS.put(p8.getCodigo(), p8);
		PRODUCTOS.put(p9.getCodigo(), p9);
		PRODUCTOS.put(p10.getCodigo(), p10);
		
	}

}
