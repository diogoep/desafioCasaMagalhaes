import Repository from "./Repository";

export default {
    getAll(idLoja) {
        return Repository.get(`/lojas/${idLoja}/produtos`)
      },
      create(produtoLoja){
        return Repository.post(`/lojas/${produtoLoja.idLoja}/produtos`, produtoLoja)
      },
      update(produtoLoja){
        return Repository.put(`/lojas/${produtoLoja.idLoja}/produtos/${produtoLoja.idProduto}`, produtoLoja)
      },
      delete(idLoja, idProduto){
        return Repository.delete(`/lojas/${idLoja}/produtos/${idProduto}`)
      }
}