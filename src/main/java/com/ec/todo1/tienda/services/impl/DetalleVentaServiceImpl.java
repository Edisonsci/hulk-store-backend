/**
 * 
 */
package com.ec.todo1.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ec.todo1.tienda.dto.response.DetalleVentaResponse;
import com.ec.todo1.tienda.models.dao.IDetalleVentaDao;
import com.ec.todo1.tienda.models.dao.IProductoDao;
import com.ec.todo1.tienda.models.entity.DetalleVenta;
import com.ec.todo1.tienda.models.entity.Producto;
import com.ec.todo1.tienda.services.IDetalleVentaService;

/**
 * The interface which represent ServiceImpl for the detalle venta database table. 
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
@Service
@Transactional
public class DetalleVentaServiceImpl  implements IDetalleVentaService{

	@Autowired
	private IDetalleVentaDao detalleVentaDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public List<DetalleVenta> obtenerDetalleVentas() {
		return (List<DetalleVenta>) detalleVentaDao.findAll();
	}

	@Override
	public DetalleVentaResponse crearDetalleVenta(DetalleVenta detalleVenta) {
		detalleVenta = detalleVentaDao.save(detalleVenta);
		return doDetalleventaResponse(detalleVenta);
	}

	/**
	 * Método que permite transfomar de tipo DetalleVenta a DetalleVentaResponse
	 * @param detalleVenta
	 * @return
	 */
	private DetalleVentaResponse doDetalleventaResponse(DetalleVenta detalleVenta) {
		DetalleVentaResponse detalleVentaResponse = new DetalleVentaResponse(detalleVenta.getCantidad(), detalleVenta.getSubtotal(),detalleVenta.getTotal());
		int idDeta = detalleVenta.getProducto().getId();
		Producto p = new Producto();
		p = productoDao.findById(idDeta).orElse(null);
		detalleVentaResponse.setProducto(p.getNombre());
		return detalleVentaResponse;
	}
	
	
}
