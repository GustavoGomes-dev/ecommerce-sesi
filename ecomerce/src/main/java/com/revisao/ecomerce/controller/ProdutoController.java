	package com.revisao.ecomerce.controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.revisao.ecomerce.dto.ProdutoDTO;
	import com.revisao.ecomerce.service.ProdutoService;
	
	@RestController
	@RequestMapping("/produtos")
	public class ProdutoController {
	
		@Autowired
		private ProdutoService service;
		
		@GetMapping
		public List<ProdutoDTO> findAll(){
			return  service.findAll();
			
		}
		
		@GetMapping(value = "/pagina")
		public Page<ProdutoDTO> findAll(Pageable pagina){
			return service.FindPagina(pagina);
		}
		
		@PostMapping()
		public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO dto){
			dto = service.insert(dto);
			return ResponseEntity.ok(dto);
		}
	}   