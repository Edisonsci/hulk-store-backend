package com.ec.todo1.tienda.services;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.IngresoResponse;
import com.ec.todo1.tienda.models.entity.Ingreso;

/**
 * The interface which represent Service for the ingreso database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
public interface IIngresoService {
	
	public void eliminar(Integer id);

	public IngresoResponse crearIngreso(Ingreso reqIngreso);

	public BodyListResponse<IngresoResponse> obtenerIngresos();
}
