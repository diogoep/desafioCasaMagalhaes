import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';
import axios from 'axios'
import VueMoment from 'vue-moment'

axios.defaults.baseURL = process.env.VUE_APP_API_URL;

// Adiciona token na requisição
Vue.config.productionTip = false
Vue.use(VueMoment)

new Vue({
  router,
  store,
  vuetify,
  render: function (h) { return h(App) }
}).$mount('#app')
