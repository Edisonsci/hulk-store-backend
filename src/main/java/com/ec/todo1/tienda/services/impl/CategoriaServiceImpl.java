/**
 * 
 */
package com.ec.todo1.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.todo1.tienda.models.dao.ICategoriaDao;
import com.ec.todo1.tienda.models.entity.Categoria;
import com.ec.todo1.tienda.services.ICategoriaService;

/**
 * The interface which represent ServiceImpl for the categoria database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Service
@Transactional
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> obtenerCategorias() {
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		Categoria categoriaExiste = categoriaDao.findByCodigo(categoria.getCodigo());
		if (categoriaExiste == null) {
			return categoriaDao.save(categoria);
		}
		return null;
	}
}
