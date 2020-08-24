import router from "../../router";
import {RepositoryFactory} from "@/repositories/RepositoryFactory"

let lojaRepository

const state = {
    loja: null
}

const mutations = {
    SET_LOJA: (state, loja) => {
        state.loja = loja
    }
}

const actions = {
    createLoja({ commit }, loja) {
        lojaRepository = RepositoryFactory.get("loja")
        lojaRepository.create(loja)
            .then(() => {
                commit('SET_LOJA', loja)
                router.push("/")
            })
            .catch(console.error)       

    },

    updateLoja({ commit }, loja) {
        lojaRepository = RepositoryFactory.get("loja")
        lojaRepository.update(loja)
            .then(() => {
                commit('SET_LOJA', loja)
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