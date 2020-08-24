<template>
    <v-app>
        <template v-if="!$route.meta.public">
            <v-app-bar color="primary" dark dense app>
                <v-toolbar-items class="ml-3">
                    <v-btn to="/" text>Lojas</v-btn>
                    <v-btn to="/listarProdutos" text>Produtos</v-btn>
                </v-toolbar-items>

              <v-spacer></v-spacer>
            </v-app-bar>

            <v-content class="content">
                <v-container fluid class="page-wrapper">
                    <router-view></router-view>
                </v-container>
            </v-content>

            <!-- App Footer -->
            <v-footer height="auto" class="white pa-3 app--footer" app>
                <span class="caption">Projeto desenvolvido por Diogo Eliseu Paulo &copy; {{ new Date().getFullYear() }}</span>
            </v-footer>
        </template>

        <template v-else>
          <transition>
            <keep-alive>
              <router-view :key="$route.fullpath"></router-view>
            </keep-alive>
          </transition>
        </template>
    </v-app>
</template>

<script>

// import axios from 'axios';

export default {
  name: 'App',

  data: () => ({
      nome: ''
  }),

    created() {
        this.nome = localStorage.getItem("nome")
    },

    methods: {
        /*logout() {
            this.$router.push('/logout')
        }*/

    }
};
</script>

<style lang="stylus" scoped>
    .page-wrapper
        min-height: calc(100vh - 64px - 50px - 81px );

    .content
        background-color: #cbcedd;;

</style>
