/**
 * 
 */
package com.ec.todo1.tienda.services;

import java.util.List;

import com.ec.todo1.tienda.dto.response.DetalleVentaResponse;
import com.ec.todo1.tienda.models.entity.DetalleVenta;

/**
 * The interface which represent Service for the detalle categoria database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
public interface IDetalleVentaService {

	public List<DetalleVenta> obtenerDetalleVentas();
	public DetalleVentaResponse crearDetalleVenta(DetalleVenta detalleVenta);
}
