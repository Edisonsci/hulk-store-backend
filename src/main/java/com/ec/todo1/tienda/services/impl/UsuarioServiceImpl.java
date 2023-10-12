package com.ec.todo1.tienda.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.todo1.tienda.dto.response.BodyResponse;
import com.ec.todo1.tienda.dto.response.UsuarioResponse;
import com.ec.todo1.tienda.models.dao.IRolDao;
import com.ec.todo1.tienda.models.dao.IUsuarioDao;
import com.ec.todo1.tienda.models.entity.Usuario;
import com.ec.todo1.tienda.services.IUsuarioService;
/**
 * The interface which represent ServiceImpl for the usuario database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IRolDao rolDao;
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	/**
	 * Método que permite transfomar de tipo Usuario a UsuarioResponse
	 * @param usuario
	 * @return
	 */
	private UsuarioResponse doUsusarioResponse(Usuario usuario) {
		UsuarioResponse usuarioResponse = new UsuarioResponse(usuario.getId(), usuario.getApellidos(), usuario.getNombres(),
				usuario.getDireccion(), usuario.getTelefono(), usuario.getCorreo());
		usuarioResponse.setRol(rolDao.findById(usuario.getRol().getId()).orElse(null).getRol());
		return usuarioResponse;
	}

	/**
	 * Método que permite crear un Usuario en la bdd
	 * @param usuario
	 * @return
	 */
	@Override
	public BodyResponse<UsuarioResponse> crearUsuario(Usuario usuario) {
		usuario.setFecha(new Date());
		Usuario usuarioExiste = usuarioDao.findByCorreo(usuario.getCorreo());
		if (usuarioExiste == null) {
			usuario = usuarioDao.save(usuario);
			return new BodyResponse<>(doUsusarioResponse(usuario));
		}
		return null;
	}

	/**
	 * Método que obtiene un Usuario por correo y password
	 * @param correo
	 * @param password
	 * @return
	 */
	@Override
	public BodyResponse<UsuarioResponse> obtenerPorCorreoPassword(String correo, String password){
		Usuario respuesta = usuarioDao.findByCorreoAndPassword(correo, password);
		if(respuesta != null){
			 return new BodyResponse<>(doUsusarioResponse(respuesta));
		}
		return null;
	}

	@Override
	public Usuario findById(Integer id) {
		return usuarioDao.findById(id).orElse(null);
	}
}
