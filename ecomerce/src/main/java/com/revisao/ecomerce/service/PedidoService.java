package com.revisao.ecomerce.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecomerce.dto.PedidoDTO;
import com.revisao.ecomerce.entity.Pedido;
import com.revisao.ecomerce.entity.StatusDoPedido;
import com.revisao.ecomerce.entity.Usuario;
import com.revisao.ecomerce.repository.PedidoRepository;
import com.revisao.ecomerce.repository.UsuarioRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;


    public PedidoDTO inserir(PedidoDTO dto) {
    	Pedido pedido = new Pedido();
    	pedido.setMomento(Instant.now());
    	pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
    	
    	Usuario user = usuarioRepo.getReferenceById(dto.getClienteid());
    	
    	pedido.setCliente(user);
    	pedido = pedidoRepo.save(pedido);
    	return new PedidoDTO(pedido);
    }

}
