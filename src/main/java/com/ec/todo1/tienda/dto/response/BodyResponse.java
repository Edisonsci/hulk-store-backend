package com.ec.todo1.tienda.dto.response;


/**
 * Body for the response - API REST.
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
public class BodyResponse<T> {

	private T data;

	public BodyResponse(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
