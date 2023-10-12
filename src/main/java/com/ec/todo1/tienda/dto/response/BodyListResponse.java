package com.ec.todo1.tienda.dto.response;


/**
 * Body List for the response - API REST.
 * Hulk Store 2019 - Todos los derechos reservados
 * @author edisoncsi
 * @version $1.0$
 */
import java.util.List;

public class BodyListResponse<T> {

	private List<T> data;

	public BodyListResponse(List<T> data) {
		super();
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}
