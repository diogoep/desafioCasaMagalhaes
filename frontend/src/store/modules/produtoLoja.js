import router from "../../router";
import {RepositoryFactory} from "@/repositories/RepositoryFactory"

let produtosLojaRepository

const state = {
    produtLoja: null
}

const mutations = {
    SET_PRODUTO: (state, produtoLoja) => {
        state.produtoLoja = produtoLoja
    }
}

const actions = {
    createProdutoLoja({ commit }, produtoLoja) {
        produtosLojaRepository = RepositoryFactory.get("produtosLoja")
        produtosLojaRepository.create(produtoLoja)
            .then(() => {
                commit('SET_PRODUTO', produtoLoja)
                router.push("/")
            })
            .catch(console.error)       

    },

    updateProdutoLoja({ commit }, produtoLoja) {
        produtosLojaRepository = RepositoryFactory.get("produtosLoja")
        produtosLojaRepository.update(produtoLoja)
            .then(() => {
                commit('SET_PRODUTO', produtoLoja)
                router.push("/")
            })
            .catch(console.error)       

    }
}

export default {
    namespaced: true,
    state,
    actions,
    mutations
}