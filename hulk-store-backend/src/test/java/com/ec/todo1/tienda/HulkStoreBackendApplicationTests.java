package com.ec.todo1.tienda;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ec.todo1.tienda.controllers.ProductoControllerTest;


@SpringBootTest
class HulkStoreBackendApplicationTests {

	@Autowired
	ProductoControllerTest producto;
	@Test
	void contextLoads() throws Exception {
	assertThat(producto).isNotNull();
	}

}
