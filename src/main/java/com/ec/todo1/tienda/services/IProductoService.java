/**
 * 
 */
package com.ec.todo1.tienda.services;

import java.util.List;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.ProductoResponse;
import com.ec.todo1.tienda.models.entity.Producto;

/**
 * The interface which represent Service for the producto database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
public interface IProductoService {
	
	public ProductoResponse crearProducto(Producto producto);
	public void eliminar(Integer id);
	public BodyListResponse<ProductoResponse> obtenerProductos();	
	public Producto findById(Integer id);
	
	public List<Producto> getProductos();
}
