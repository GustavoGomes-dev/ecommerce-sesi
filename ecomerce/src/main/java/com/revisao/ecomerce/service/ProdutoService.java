	package com.revisao.ecomerce.service;
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revisao.ecomerce.dto.CategoriaDTO;
import com.revisao.ecomerce.dto.ProdutoDTO;
import com.revisao.ecomerce.entity.Categoria;
import com.revisao.ecomerce.entity.Produto;
import com.revisao.ecomerce.repository.CategoriaRepository;
import com.revisao.ecomerce.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
	
	@Service
	public class ProdutoService {
	
		@Autowired
		ProdutoRepository repo;
		
		@Autowired
		CategoriaRepository repo1;
		
		public List<ProdutoDTO> findAll(){
			List<Produto> lista = repo.findAll();
			return lista.stream().map(x -> new ProdutoDTO(x)).toList();
		}
		
		public Page<ProdutoDTO> FindPagina(Pageable pagina){
			Page<Produto> busca = repo.findAll(pagina);
			return busca.map(x -> new ProdutoDTO(x));
		} 
		
		@Transactional
		public ProdutoDTO insert(ProdutoDTO dto) {
			Produto entity = new Produto();
			entity.setNome(dto.getNome());
			entity.setDescricao(dto.getDescricao());
			entity.setPreco(dto.getPreco());
			entity.setImgUrl(dto.getImgUrl());
			
			for(CategoriaDTO cDto : dto.getCategorias()) {
				Categoria cat = repo1.getReferenceById(cDto.getId());
				entity.getCategorias().add(cat);
			}
			
			entity = repo.save(entity);
			return new ProdutoDTO(entity);
		}
	}
