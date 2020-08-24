import Vue from 'vue'
import Vuex from 'vuex'

import produto from './modules/produto'
import loja from './modules/loja'
import produtoLoja from './modules/produtoLoja'


Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    produto: produto,
    loja: loja,
    produtoLoja: produtoLoja
  }
})
