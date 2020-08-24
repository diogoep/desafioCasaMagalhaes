package com.desafioCasaMagalhaes.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="produto_loja")
@IdClass(ProdutoLojaID.class)
public class ProdutoLoja implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "quantidade")
	private Double quantidade;
	
	@Id
	@MapsId("idProduto")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_produto", nullable=false, updatable=false, referencedColumnName = "id_produto")
	private Produto produto;
	
	@Id
	@MapsId("idLoja")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_loja", nullable=false, updatable=false, referencedColumnName = "id_loja")
	private Loja loja;
	
	public Double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Loja getLoja() {
		return loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}