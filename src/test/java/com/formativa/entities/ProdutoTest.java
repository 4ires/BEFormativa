package com.formativa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

private Produto produto;
	
	@BeforeEach
	void setUp() {
		produto = new Produto(1L, "Pelúcia Goku", "Brinquedo de pelúcia", 28.90);
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		produto.setId(1L);
		//Assert
		assertEquals(1L, produto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		produto.setNome("Pelúcia Goku");
		//Assert
		assertEquals("Pelúcia Goku", produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo descrição")
	void testDescricao() {
		//Act
		produto.setDescricao("Brinquedo de pelúcia");
		//Assert
		assertEquals("Brinquedo de pelúcia", produto.getDescricao());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo preço")
	void testPreco() {
		//Act
		produto.setPreco(28.90);
		//Assert
		assertEquals(28.90, produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Produto novoProduto = new Produto(2L, "Pelúcia Goku", "Brinquedo de pelúcia", 28.90);
		//Assertion
		assertAll("novoProduto", 
				()-> assertEquals("Pelúcia Gokuu", novoProduto.getNome()),
				()-> assertEquals("Brinquedo de pelúcia", novoProduto.getDescricao()),
				()-> assertEquals(28.90, novoProduto.getPreco()));
		
	}

}
