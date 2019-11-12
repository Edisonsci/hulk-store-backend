package com.ec.todo1.tienda.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.VentaResponse;
import com.ec.todo1.tienda.models.dao.IProductoDao;
import com.ec.todo1.tienda.models.dao.IUsuarioDao;
import com.ec.todo1.tienda.models.dao.IVentaDao;
import com.ec.todo1.tienda.models.entity.Producto;
import com.ec.todo1.tienda.models.entity.Usuario;
import com.ec.todo1.tienda.models.entity.Venta;
import com.ec.todo1.tienda.services.IVentaService;

/**
 * The interface which represent ServiceImpl for the venta database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Service
@Transactional
public class VentaServiceImpl implements IVentaService {
	@Autowired
	private IVentaDao ventaDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	/**
	 * Método que permite transfomar de tipo Venta a VentaResponse
	 * @param venta
	 * @return
	 */
	private VentaResponse doVentaResponse(Venta venta) {
		VentaResponse ventaResponse = new VentaResponse(venta.getNroDocumento(), venta.getFechaVenta(),
				venta.getSubtotal(), venta.getIva(), venta.getTotal());
		Optional<Usuario> user = usuarioDao.findById(venta.getUsuario().getId());
		ventaResponse.setUsuario(user.get().getNombres() + " " + user.get() .getApellidos());
		return ventaResponse;
	}

	/**
	 * Método que obtiene todos los Venta de la bdd
	 * @return
	 */
	@Override
	public BodyListResponse<VentaResponse> obtenerVentas() {
		List<VentaResponse> ventas = new ArrayList<>();	
		List<Venta> respuesta = (List<Venta>) ventaDao.findAll();

		if (respuesta != null && !respuesta.isEmpty()) {
			for (Venta venta : respuesta) {
				ventas.add(doVentaResponse(venta));
			}
		}
		return new BodyListResponse<>(ventas);
	}
	
	/**
	 * Método que obtiene todos los Venta de un empleado especifico
	 * @return
	 */
	@Override
	public BodyListResponse<VentaResponse> obtenerVentasPorIdUsuario(Integer idUsuario) {
		List<VentaResponse> ventas = new ArrayList<>();	
		List<Venta> respuesta = ventaDao.findByUsuarioId(idUsuario);

		if (respuesta != null && !respuesta.isEmpty()) {
			for (Venta venta : respuesta) {
				ventas.add(doVentaResponse(venta));
			}
		}
		return new BodyListResponse<>(ventas);
	}

	/**
	 * Método que permite crear un venta en la bdd
	 * @param venta
	 * @return
	 */
	@Override
	public VentaResponse crearVenta(Venta venta) {
		venta.setFechaVenta(new Date());
		venta.setNroDocumento("0000000"+ productoDao.count() + 1);
		venta.getDetalleList().forEach(detalle ->{
			Producto producto = productoDao.findById(detalle.getProducto().getId()).orElse(null);
			producto.setCantidad(producto.getCantidad() - detalle.getCantidad());
			productoDao.save(producto);
			
			detalle.setVenta(venta);
		});
		return doVentaResponse(ventaDao.save(venta));
	}

}
