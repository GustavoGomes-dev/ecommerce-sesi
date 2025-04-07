package com.revisao.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revisao.ecomerce.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
