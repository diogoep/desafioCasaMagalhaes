import Repository from "./Repository";

const resource = "/produtos";

export default {
    getByAutenticacao() {
        return Repository.get(`${resource}/produto`);
    },
    getAll() {
      return Repository.get(`${resource}`)
    },
    create(produto){
      return Repository.post(`${resource}`, produto)
    },
    update(produto){
      return Repository.put(`${resource}/${produto.id}`, produto)
    },
    delete(id){
      return Repository.delete(`${resource}/${id}`)
    }
}
