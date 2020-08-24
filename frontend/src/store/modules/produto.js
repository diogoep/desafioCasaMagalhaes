import router from "../../router";
import {RepositoryFactory} from "@/repositories/RepositoryFactory"

let produtoRepository

const state = {
    produto: null
}

const mutations = {
    SET_PRODUTO: (state, produto) => {
        state.produto = produto
    }
}

const actions = {
    createProduto({ commit }, produto) {
        produtoRepository = RepositoryFactory.get("produto")
        produtoRepository.create(produto)
            .then(() => {
                commit('SET_PRODUTO', produto)
                router.push("/")
            })
            .catch(console.error)       

    },

    updateProduto({ commit }, produto) {
        produtoRepository = RepositoryFactory.get("produto")
        produtoRepository.update(produto)
            .then(() => {
                commit('SET_PRODUTO', produto)
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