/**
 * 
 */
package com.ec.todo1.tienda.services;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.VentaResponse;
import com.ec.todo1.tienda.models.entity.Venta;

/**
 * The interface which represent Service for the venta database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
public interface IVentaService {

	VentaResponse crearVenta(Venta reqVenta);

	BodyListResponse<VentaResponse> obtenerVentas();

	BodyListResponse<VentaResponse> obtenerVentasPorIdUsuario(Integer idUsuario);

}
