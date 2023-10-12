/**
 * 
 */
package com.ec.todo1.tienda.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.IngresoResponse;
import com.ec.todo1.tienda.models.dao.IIngresoDao;
import com.ec.todo1.tienda.models.dao.IProductoDao;
import com.ec.todo1.tienda.models.dao.IUsuarioDao;
import com.ec.todo1.tienda.models.entity.Ingreso;
import com.ec.todo1.tienda.models.entity.Producto;
import com.ec.todo1.tienda.models.entity.Usuario;
import com.ec.todo1.tienda.services.IIngresoService;

/**
 * The interface which represent ServiceImpl for the ingreso database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Service
@Transactional
public class IngresoServiceImpl implements IIngresoService {

	@Autowired
	private IIngresoDao ingresoDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	/**
	 * Método que permite transfomar de tipo Ingreso a IngresoResponse
	 * @param ingreso
	 * @return
	 */
	private IngresoResponse doIngresoResponse(Ingreso ingreso) {
		IngresoResponse ingresoResponse = new IngresoResponse(ingreso.getId(), ingreso.getCantidad(), ingreso.getFechaIngreso(),ingreso.getTotal());
		
		int idDeta = ingreso.getProducto().getId();
		Producto producto = new Producto();
		producto = productoDao.findById(idDeta).orElse(null);
		ingresoResponse.setProducto(producto.getNombre());
		ingresoResponse.setPrecio(producto.getPrecio());
		Usuario user = usuarioDao.findById(ingreso.getUsuario().getId()).orElse(null);
		ingresoResponse.setUsuario(user.getNombres().toString() + " " + user.getApellidos());
		return ingresoResponse;
	}

	/**
	 * Método que obtiene todos los ingreso de la bdd
	 * @return
	 */
	@Override
	public BodyListResponse<IngresoResponse> obtenerIngresos() {
		List<IngresoResponse> productos = new ArrayList<>();	
		List<Ingreso> respuesta = (List<Ingreso>) ingresoDao.findAll();

		if (respuesta != null && !respuesta.isEmpty()) {
			for (Ingreso ingreso : respuesta) {
				productos.add(doIngresoResponse(ingreso));
			}
		}
		return new BodyListResponse<>(productos);
	}

	/**
	 * Método que permite crear un Ingreso en la bdd
	 * @param ingreso
	 * @return
	 */
	@Override
	public IngresoResponse crearIngreso(Ingreso ingreso) {
		ingreso.setFechaIngreso(new Date());
		int idDeta = ingreso.getProducto().getId();
		Producto producto = new Producto();
		producto = productoDao.findById(idDeta).orElse(null);
		producto.setCantidad(producto.getCantidad() + ingreso.getCantidad());
		productoDao.save(producto);
		return doIngresoResponse(ingresoDao.save(ingreso));
	}
	
	/**
	 * Método que permite eliminar un Ingreso de la bdd
	 * @param codigo
	 */
	@Override
	public void eliminar(Integer id) {
		Ingreso ingreso = ingresoDao.findById(id).orElse(null);
		Producto producto = ingreso.getProducto();
		producto.setCantidad(producto.getCantidad() - ingreso.getCantidad());
		productoDao.save(producto);
		ingresoDao.deleteById(id);
	}

}
