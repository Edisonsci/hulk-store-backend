package com.ec.todo1.tienda.services;

import java.util.List;

import com.ec.todo1.tienda.dto.response.BodyResponse;
import com.ec.todo1.tienda.dto.response.UsuarioResponse;
import com.ec.todo1.tienda.models.entity.Usuario;

/**
 * The interface which represent Service for the usuario database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */

public interface IUsuarioService {
	public List<Usuario> obtenerUsuarios() ;

	public BodyResponse<UsuarioResponse> crearUsuario(Usuario reqUser);

	public BodyResponse<UsuarioResponse> obtenerPorCorreoPassword(String correo, String password);
	
	public Usuario findById(Integer id);
}
