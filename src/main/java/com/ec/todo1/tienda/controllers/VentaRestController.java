package com.ec.todo1.tienda.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.VentaResponse;
import com.ec.todo1.tienda.models.entity.Venta;
import com.ec.todo1.tienda.services.IVentaService;

/**
 * The REST API for processing the incoming requests the venta. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@RestController
@RequestMapping("/venta")
public class VentaRestController {
	final static Logger logger = LoggerFactory.getLogger(VentaRestController.class);

	@Autowired
	private IVentaService ventaService;
	
	/**
	 * API REST para crear una nueva venta
	 * @param model
	 * @param reqVenta
	 * @return
	 */
	@PostMapping(produces = "application/json")
	public VentaResponse saveVenta(ModelMap model, @RequestBody Venta reqVenta) {
		VentaResponse venta = null;
		try {
			venta = ventaService.crearVenta(reqVenta);
		} catch (DataIntegrityViolationException ex) {
			logger.debug(ex.getMessage(), ex);
			throw new DataIntegrityViolationException("Verifique los datos ingresados: ");
		}
		return venta;
	}

	/**
	 * API REST para obtener todas las ventas
	 * @return
	 */
	@GetMapping(produces = "application/json")
	public BodyListResponse<VentaResponse> getVentas() {
		try {
			return ventaService.obtenerVentas();
		} catch (DataIntegrityViolationException ex) {
			logger.debug(ex.getMessage(), ex);
			throw new DataIntegrityViolationException("Verifique los datos ingresados: ");
		}

	}
	
	
	/**
	 * API REST para obtener todas las ventas
	 * @return
	 */
	@GetMapping(value="/{idUsuario}", produces = "application/json")
	public BodyListResponse<VentaResponse> getVentas(@PathVariable("idUsuario") Integer idUsuario) {
		try {
			return ventaService.obtenerVentasPorIdUsuario(idUsuario);
		} catch (DataIntegrityViolationException ex) {
			logger.debug(ex.getMessage(), ex);
			throw new DataIntegrityViolationException("Verifique los datos ingresados: ");
		}

	}
	

}
