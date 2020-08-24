import Repository from "./Repository";

const resource = "/lojas";

export default {
    getByAutenticacao() {
        return Repository.get(`${resource}/loja`);
    },
    getAll() {
      return Repository.get(`${resource}`)
    },
    create(loja){
      return Repository.post(`${resource}`, loja)
    },    
    update(loja){
      console.log(loja);
      return Repository.put(`${resource}/${loja.id}`,loja)

    },
    delete(id){
      return Repository.delete(`${resource}/${id}`)
    },
}
