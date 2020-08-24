package com.desafioCasaMagalhaes.model;

import java.io.Serializable;

public class ProdutoLojaID implements Serializable {
    private static final long serialVersionUID = -2834827403836993112L;

	private Integer produto;
	private Integer loja;
	
	public ProdutoLojaID() {}
	
    public ProdutoLojaID(Integer produto, Integer loja) {
		this.produto = produto;
		this.loja = loja;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        result = prime * result + ((loja == null) ? 0 : loja.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProdutoLojaID other = (ProdutoLojaID) obj;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        if (loja == null) {
            if (other.loja != null)
                return false;
        } else if (!loja.equals(other.loja))
            return false;
        return true;
    }
}