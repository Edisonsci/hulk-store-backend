package com.ec.todo1.tienda.services;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import com.ec.todo1.tienda.models.dao.ICategoriaDao;
import com.ec.todo1.tienda.models.entity.Categoria;
import com.ec.todo1.tienda.services.impl.CategoriaServiceImpl;


@RunWith(SpringRunner.class)
public class CategoriaServiceTest {

	@Autowired
	private ICategoriaService categoriaService;
	@MockBean
	private ICategoriaDao categoriaRepository;
	@Mock
    private Categoria category;
	
	@TestConfiguration
    static class CategoriaServiceImplTestContextConfiguration {
        @Bean
        public ICategoriaService employeeService() {
            return new CategoriaServiceImpl();
        }
    }
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	private Categoria createCategoria() {
		Categoria catalogo = new Categoria();
		catalogo.setCodigo("NEW CAMI");
		catalogo.setDescripcion("Camisetas");
		return catalogo;
	}
	
	private Categoria findCategoria() {
		Categoria catalogo = new Categoria();
		catalogo.setCodigo("CAMI");
		catalogo.setDescripcion("Camisetas");
		return catalogo;
	}
	
	@Test
	public void whenValidName_thenCategoriaShouldBeFound() {
		String name = "NEW CAMI";
		category = createCategoria();
		Categoria catalogo = findCategoria();
		when(categoriaRepository.findByCodigo(catalogo.getCodigo())).thenReturn(catalogo);
		when(categoriaRepository.save(category)).thenReturn(category);
		Categoria savedCategoria = categoriaService.crearCategoria(category);
		// Assert
		assertThat(savedCategoria.getCodigo(), is(equalTo(name)));
	}
	
	
	@Test
	public void whenValidName_thenCategoriaShouldNotFound() {
		category = createCategoria();
		when(categoriaRepository.findByCodigo(category.getCodigo())).thenReturn(category);
		when(categoriaRepository.save(category)).thenReturn(category);
		Categoria savedCategoria = categoriaService.crearCategoria(category);
		// Assert
		assertThat(savedCategoria, is(equalTo(null)));
	}
	
	@Test
	public void whenValidList_thenCategoriaShouldBeFound() {
		List<Categoria> lista = new ArrayList<>();
		lista.add(createCategoria());
		when(categoriaRepository.findAll()).thenReturn(lista);
		List<Categoria> getCategorias = categoriaService.obtenerCategorias();
		// Assert
		assertThat(getCategorias.size(), is(equalTo(1)));
	}
}

