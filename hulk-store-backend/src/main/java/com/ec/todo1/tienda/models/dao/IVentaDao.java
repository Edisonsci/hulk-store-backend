package com.ec.todo1.tienda.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.todo1.tienda.models.entity.Venta;

/**
 * The interface which represent DOA for the venta database table.
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Repository
public interface IVentaDao extends CrudRepository<Venta, Integer> {
	
	List<Venta> findByUsuarioId(Integer id);

}
