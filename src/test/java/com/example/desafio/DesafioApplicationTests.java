package com.example.desafio;

import com.example.desafio.dto.ProductDTO;
import com.example.desafio.repositories.impl.ProductRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class DesafioApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductRepositoryImpl repository;

	@Test
	public void shouldShowAllProducts() throws Exception{
		List<ProductDTO> expectedResponse = new ArrayList<>();
		HashMap<Integer, ProductDTO> map = new HashMap<>();

		ProductDTO product1 = (new ProductDTO("Desmalezadora", "Herramientas", "Makita", 9600, 5, true, "****"));
		ProductDTO product2 = (new ProductDTO("Taladro", "Herramientas", "Black & Decker", 12500, 7, true, "****"));
		ProductDTO product3 = (new ProductDTO("Soldadora", "Herramientas", "Black & Decker", 7215, 10, true, "***"));
		ProductDTO product4 = (new ProductDTO("Zapatillas Deportivas", "Deportes", "Nike", 14000, 4, true, "*****"));

		expectedResponse.add(product1);
		expectedResponse.add(product2);
		expectedResponse.add(product3);
		expectedResponse.add(product4);

		map.put(1, product1);
		map.put(2, product2);
		map.put(3, product3);
		map.put(4, product4);

		when(repository.loadInventory()).thenReturn(expectedResponse);
		//when(repository.orderList(repository.getInventory(), null)).thenReturn(expectedResponse);
		//List<ProductDTO> respInventory = repository.getInventory();
		//when(repository.searchProducts(new HashMap<>(), 0)).thenCallRealMethod();
		this.mockMvc.perform(get("/api/v1/articles/"))
				.andDo(print())
				.andExpect(status().isOk())
				//.andExpect(jsonPath("$",hasSize(4)));
				//.andExpect((jsonPath("$[0].name").value("Desmalezadora")));
				.andExpect(content().json("[{\"name\":\"Desmalezadora\",\"category\":\"Herramientas\",\"brand\":\"Makita\",\"price\":9600,\"stock\":5,\"freeShipping\":true,\"prestige\":\"****\"},{\"name\":\"Taladro\",\"category\":\"Herramientas\",\"brand\":\"Black & Decker\",\"price\":12500,\"stock\":7,\"freeShipping\":true,\"prestige\":\"****\"},{\"name\":\"Soldadora\",\"category\":\"Herramientas\",\"brand\":\"Black & Decker\",\"price\":7215,\"stock\":10,\"freeShipping\":true,\"prestige\":\"***\"},{\"name\":\"Zapatillas Deportivas\",\"category\":\"Deportes\",\"brand\":\"Nike\",\"price\":14000,\"stock\":4,\"freeShipping\":true,\"prestige\":\"*****\"}]"));
	}

}
