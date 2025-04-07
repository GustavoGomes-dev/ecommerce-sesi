package com.revisao.ecomerce.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity

@Table(name ="tb_item_pedido")
public class ItemDoPedido {

	@EmbeddedId
	private ItemDoPedidoPK id = new ItemDoPedidoPK();
	
	private Integer quantidade;
	private Double preco;
	
	
	
	public ItemDoPedido() {
		
	}



	public ItemDoPedido(Pedido pedido, Produto produto,int quantidade, Double preco) {
		id.setProduto(produto);
		id.setPedido(pedido);
		this.quantidade = quantidade;
		this.preco = preco;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public Double getPreco() {
		return preco;
	}



	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void setpedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	public Produto getProduto() {
		return id.getProduto();
	}
}
