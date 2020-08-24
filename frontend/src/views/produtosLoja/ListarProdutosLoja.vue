<template>
    <div>
      <v-card-widget enableActions :title="'Produtos'">
        <div slot="widget-header-action"></div>
        <div slot="widget-content">
          <v-row>
            <v-col cols="12">
              <v-data-table
                :headers="headers"
                :items="produtosLoja"
                :items-per-page="5"
                class="elevation-1"
              >
              <template v-slot:footer >
                <v-toolbar align="right" flat color="white">                   
                  <v-btn color="primary" dark dense app @click="addItem()"><v-icon>mdi-plus</v-icon>Adicionar</v-btn>
                </v-toolbar>
              </template>
              <template v-slot:item.actions="{ item }">
                <v-icon small class="mr-2" @click="editItem(item)">mdi-pencil</v-icon>
                <v-icon small @click="deleteItem(item)">mdi-delete</v-icon>
              </template>
              </v-data-table>
            </v-col>
          </v-row>
        </div>
      </v-card-widget>
    </div>
  </template>
  <script>
  // @ is an alias to /src
  import VCardWidget from "@/components/VWidget";
  import { RepositoryFactory } from "@/repositories/RepositoryFactory";
  const produtosLojaRepo = RepositoryFactory.get("produtosLoja");
  
  export default {
    name: "listarProdutosLoja",
    components: {
      VCardWidget
    },
  
    data: () => ({
      headers: [
        { text: "Quantidade", align: "left", value: "quantidade" },
        { text: "Descrição", value: "produto.nome" },
        { text: "", value: "actions", sortable: false }
      ],
      produtosLoja: []
    }),
  
    created() {

      produtosLojaRepo
        .getAll(this.$route.params.data.id)
        .then(res => {
          this.produtosLoja = res.data;
        })
        .catch(console.error);
              
    },
  
    computed: {},
  
    methods: {
      loadprodutos(){
        produtosLojaRepo
        .getAll(this.$route.params.data.id)
        .then(res => {
          this.produtosLoja = res.data;
        })
        .catch(console.error);
      },
      deleteItem(item){
        produtosLojaRepo.delete(item.loja.id, item.produto.id).then(() => {
          this.loadprodutos();
        })
        .catch(console.error);
      },
      addItem(){
        this.$router.push({name: 'AdicionarProdutoLoja', params:{ data: this.$route.params.data}});
      },
      editItem(item){
        this.$router.push({name: 'AdicionarProdutoLoja', params: { data: item}});  
      }
    }
  };
  </script>
  