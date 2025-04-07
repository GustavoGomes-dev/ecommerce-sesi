package com.revisao.ecomerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecomerce.dto.PedidoDTO;
import com.revisao.ecomerce.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;


    @PostMapping(value = "/pedido")
    public ResponseEntity<PedidoDTO> insert(@RequestBody PedidoDTO dto) {
        PedidoDTO pedido = service.inserir(dto);
        return ResponseEntity.ok(pedido);
    }
}
