package com.formativa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.formativa.entities.Produto;
import com.formativa.repository.ProdutoRepository;

@DataJpaTest
class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		//Given / Arrange
		Produto produto1 = new Produto (null, "Pelúcia Goku", "Brinquedo de pelúcia", 28.90);
		//When /Act
		Produto saveProduto = produtoRepository.save(produto1);
		
		//Then /Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
	}
	
	@DisplayName("Testando Get para todos Hospedes")
	@Test
	void testGetAllRepository() {
		
		//Given / Arrange
		
		Produto produto1 = new Produto(null, "Pelúcia Goku", "Brinquedo de pelúcia", 28.90);
		
		Produto produto2 = new Produto(null, "Pelúcia Hello Kitty", "Brinquedo de pelúcia", 30.00);
		
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		
		List<Produto> produtoList = produtoRepository.findAll();
		
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());
	}
	@DisplayName("Testando Get por ID")
	@Test
	void testGetById() {
		
		//Given / Arrange
		
		Produto produto1 = new Produto(null, "Pelúcia Hello Kitty", "Brinquedo de pelúcia", 30.00);
		
		produtoRepository.save(produto1);
		
		//When / Act
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveProduto);
		assertEquals(produto1.getId(), saveProduto.getId());
		
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateHospede() {
		
		//Given / Arrange
		
		Produto produto1 = new Produto(null, "Pelúcia Hello Kitty", "Brinquedo de pelúcia", 30.00);
		
		produtoRepository.save(produto1);
		
		//When /Act
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("Travesseiro");
		produto1.setDescricao("Rosa");
		
		Produto updateProduto = produtoRepository.save(saveProduto);
		
		//Then / Assert
		assertNotNull(updateProduto);
		assertEquals("Travesseiro", updateProduto.getNome());
		assertEquals("Rosa", updateProduto.getDescricao());
	}
	
	@DisplayName("Testando Update")
	@Test
	void testDeleteProduto() {
		
		//Given / Arrange
		
		Produto produto1 = new Produto(null, "Pelúcia Hello Kitty", "Brinquedo de pelúcia", 30.00);
		
		produtoRepository.save(produto1);
		
		//When /Act
		produtoRepository.deleteById(produto1.getId());
		
		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());
		
		//Then /Assert
		
		assertTrue(produtoOptional.isEmpty());
	}

}
