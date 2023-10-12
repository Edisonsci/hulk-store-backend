package com.ec.todo1.tienda.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.todo1.tienda.models.entity.DetalleVenta;


/**
 * The interface which represent DOA for the detalle_venta database table.
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Repository
public interface IDetalleVentaDao extends CrudRepository<DetalleVenta, Integer>{

}