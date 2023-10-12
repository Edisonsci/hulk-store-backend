package com.ec.todo1.tienda.controllers;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.ProductoResponse;
import com.ec.todo1.tienda.models.entity.Producto;
import com.ec.todo1.tienda.services.IProductoService;

/**
 * The REST API for processing the incoming requests the Producto. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */

@RestController
@RequestMapping("/producto")
public class ProductoRestController extends BaseRestController {
	final static Logger logger = LoggerFactory.getLogger(IngresoRestController.class);
	
	@Autowired
	private IProductoService productoService;

	/**
	 * API REST para crear un producto
	 * @param model
	 * @param reqProducto
	 * @return
	 */
	@PostMapping(produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoResponse saveProducto(@RequestBody Producto reqProducto) {
		ProductoResponse producto = null;
		try {
			producto = productoService.crearProducto(reqProducto);
		} catch (DataIntegrityViolationException ex) {
			logger.debug(ex.getMessage(), ex);
			throw new DataIntegrityViolationException("Verifique los datos ingresados: ");
		}
		if(producto == null) {
			throw new NoSuchElementException("Ya existe un producto con nombre: " + reqProducto.getNombre());
		}
		return producto;
	}

	/**
	 * API REST para obtener todos los productos
	 * @return
	 */
	@GetMapping(produces = "application/json")
	public BodyListResponse<ProductoResponse> getProductos() {
		try {
			return productoService.obtenerProductos();
		} catch (DataIntegrityViolationException ex) {
			logger.debug(ex.getMessage(), ex);
			throw new DataIntegrityViolationException("Verifique los datos ingresados: ");
		}
	}
	
	/*@GetMapping()
	public List<Producto> getProductos() {
		try {
			return productoService.getProductos();
		} catch (DataIntegrityViolationException ex) {
			logger.debug(ex.getMessage(), ex);
			throw new DataIntegrityViolationException("Verifique los datos ingresados: ");
		}

	}*/
	
	/**
	 * API REST para eliminar un producto
	 * @return
	 */
	@RequestMapping(path="/{id}", produces="application/json")
	public void eliminarPaquete(@PathVariable(value="id") Integer codigo){
		try {
			productoService.eliminar(codigo);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarPaquete : " +e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	
}
