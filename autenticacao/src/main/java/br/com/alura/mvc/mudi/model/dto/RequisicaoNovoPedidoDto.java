package br.com.alura.mvc.mudi.model.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;

public class RequisicaoNovoPedidoDto {
	
	@NotBlank
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public PedidoEntity toPedido() {
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setDescricao(descricao);
		pedidoEntity.setNomeProduto(nomeProduto);
		pedidoEntity.setUrlImagem(urlImagem);
		pedidoEntity.setUrlProduto(urlProduto);
		pedidoEntity.setStatus(StatusPedido.AGUARDANDO);
		return pedidoEntity;
	}
	
	
}
