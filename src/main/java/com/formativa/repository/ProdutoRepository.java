package com.formativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formativa.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
