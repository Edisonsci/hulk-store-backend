package com.ec.todo1.tienda.dto.response;


import java.math.BigDecimal;

/**
 * DTO for response the DetalleVenta - API REST.
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
public class DetalleVentaResponse {

	private Integer cantidad;
	private String producto;
	private BigDecimal subtotal;
	private BigDecimal total;
	
	public DetalleVentaResponse(Integer cantidad, BigDecimal subtotal, BigDecimal total) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.total = total;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the subtotal
	 */
	public BigDecimal getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
		
}
