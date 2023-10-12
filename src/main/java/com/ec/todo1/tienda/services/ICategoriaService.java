package com.ec.todo1.tienda.services;

import java.util.List;

import com.ec.todo1.tienda.models.entity.Categoria;

/**
 * The interface which represent Service for the categoria database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */

public interface ICategoriaService {

	public List<Categoria> obtenerCategorias();
	
	public Categoria crearCategoria(Categoria categoria);
	
}
