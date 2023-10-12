/**
 * 
 */
package com.ec.todo1.tienda.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.ProductoResponse;
import com.ec.todo1.tienda.models.dao.ICategoriaDao;
import com.ec.todo1.tienda.models.dao.IProductoDao;
import com.ec.todo1.tienda.models.entity.Producto;
import com.ec.todo1.tienda.services.IProductoService;

/**
 * The interface which represent ServiceImpl for the producto database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Service
@Transactional
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	public ProductoResponse crearProducto(Producto producto) {
		producto.setFecha(new Date());
		Producto productoExiste = productoDao.findByNombre(producto.getNombre());
		if (productoExiste == null) {
			producto = productoDao.save(producto);
			return doProductoResponse(producto);
		}
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		productoDao.deleteById(id);
	}

	/**
	 * Método que permite transfomar de tipo Producto a ProductoResponse
	 * @param producto
	 * @return
	 */
	private ProductoResponse doProductoResponse(Producto producto) {
		ProductoResponse productoResponse = new ProductoResponse(producto.getId(), producto.getNombre(), producto.getDescripcion(),
				producto.getFecha(), producto.getCantidad(), producto.getUrl(), producto.getPrecio());
		productoResponse.setCategoria(categoriaDao.findByCodigo(producto.getCategoria().getCodigo()).getDescripcion());
		return productoResponse;
	}

	/**
	 * Método que obtiene todos los producto de la bdd
	 * @return
	 */
	@Override
	public BodyListResponse<ProductoResponse> obtenerProductos() {
		List<ProductoResponse> productos = new ArrayList<>();
		List<Producto> respuesta = (List<Producto>) productoDao.findAll();

		if (respuesta != null && !respuesta.isEmpty()) {
			for (Producto prod : respuesta) {
				productos.add(doProductoResponse(prod));
			}
		}
		return new BodyListResponse<>(productos);
	}

	@Override
	public Producto findById(Integer id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> getProductos() {
		return (List<Producto>) productoDao.findAll();
	}
	
	
}
