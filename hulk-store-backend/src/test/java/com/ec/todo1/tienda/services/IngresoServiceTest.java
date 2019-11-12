package com.ec.todo1.tienda.services;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ec.todo1.tienda.dto.response.BodyListResponse;
import com.ec.todo1.tienda.dto.response.IngresoResponse;
import com.ec.todo1.tienda.models.dao.IIngresoDao;
import com.ec.todo1.tienda.models.dao.IProductoDao;
import com.ec.todo1.tienda.models.dao.IUsuarioDao;
import com.ec.todo1.tienda.models.entity.Ingreso;
import com.ec.todo1.tienda.models.entity.Producto;
import com.ec.todo1.tienda.models.entity.Usuario;
import com.ec.todo1.tienda.services.impl.IngresoServiceImpl;



@RunWith(SpringRunner.class)
public class IngresoServiceTest {

	@Autowired
	private IIngresoService ingresoService;
	@MockBean
	private IIngresoDao ingresoRepository;
	@MockBean
	private IProductoDao productoRepository;
	@MockBean
	private IUsuarioDao usuarioRepository;
	
	@Mock
    private Ingreso ingreso;
	
	@TestConfiguration
    static class IngresoServiceImplTestContextConfiguration {
        @Bean
        public IngresoServiceImpl employeeService() {
            return new IngresoServiceImpl();
        }
    }
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		//ingresoService = new IngresoService(ingresoRepository, productoRepository, usuarioRepository);
	}
	
	private Producto findProducto() {
		Producto producto = new Producto();
		producto.setId(2);
		producto.setNombre("Supereroes one");
		producto.setDescripcion("Era Marvel de los Comics 1961-1978");
		producto.setCantidad(10);
		producto.setPrecio(new BigDecimal(10));
		producto.setUrl("url");
		return producto;
	}
	
	private Usuario findUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombres("Manuel");
		usuario.setApellidos("Cepeda");
		return usuario;
	}
	
	
	private Ingreso createIngreso() {
		Ingreso ingreso = new Ingreso();
		ingreso.setId(1);
		ingreso.setCantidad(2);
		ingreso.setFechaIngreso(new Date());
		ingreso.setTotal(new BigDecimal(200));
		ingreso.setProducto(findProducto());
		ingreso.setUsuario(findUsuario());
		return ingreso;
	}
	
	@Test
	public void whenValidName_thenIngresoShouldBeFound() {
		BigDecimal total = new BigDecimal(200);
		ingreso = createIngreso();
		when(productoRepository.findById(findProducto().getId()).orElse(null)).thenReturn(findProducto());
		when(usuarioRepository.findById(findUsuario().getId()).orElse(null)).thenReturn(findUsuario());
		when(ingresoRepository.save(ingreso)).thenReturn(ingreso);
		IngresoResponse savedIngreso = ingresoService.crearIngreso(ingreso);
		// Assert
		assertThat(savedIngreso.getTotal(), is(equalTo(total)));
	}
	
	
	@Test
	public void whenValidList_thenIngresoShouldBeFound() {
		List<Ingreso> lista = new ArrayList<>();
		lista.add(createIngreso());
		when(productoRepository.findById(findProducto().getId()).orElse(null)).thenReturn(findProducto());
		when(usuarioRepository.findById(findUsuario().getId()).orElse(null)).thenReturn(findUsuario());
		when(ingresoRepository.findAll()).thenReturn(lista);
		BodyListResponse<IngresoResponse> getIngresos = ingresoService.obtenerIngresos();
		// Assert
		assertThat(getIngresos.getData().size(), is(equalTo(1)));
	}
	
	
	@Test
    public void shouldCallDeleteMethodOfIngresoRepository_whenDeleteProductIsCalled() throws Exception {
		ingreso = createIngreso();
		when(ingresoRepository.findById(ingreso.getId()).orElse(null)).thenReturn(ingreso);
        doNothing().when(ingresoRepository).deleteById(1);
        ingresoService.eliminar(1);
        // Assert
        verify(ingresoRepository, times(1)).deleteById(1);
    }
}
