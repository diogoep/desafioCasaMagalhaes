<template>
    <div>
      <v-card-widget enableActions :title="'Produtos'">
        <div slot="widget-header-action"></div>
        <div slot="widget-content">
          <v-row>
            <v-col cols="12">
              <v-data-table
                :headers="headers"
                :items="produtos"
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
  const produtoRepo = RepositoryFactory.get("produto");
  
  export default {
    name: "listarProdutos",
    components: {
      VCardWidget
    },
  
    data: () => ({
      headers: [
        {
          text: "Nome",
          align: "left",
          value: "nome"
        },
        { text: "Descrição", value: "descricao" },
        { text: "Marca", value: "marca" },
        { text: "", value: "actions", sortable: false }
      ],
      produtos: []
    }),
  
    created() {
      produtoRepo
        .getAll()
        .then(res => {
          this.produtos = res.data;
        })
        .catch(console.error);
    },
  
    computed: {},
  
    methods: {
      loadprodutos(){
        produtoRepo
        .getAll()
        .then(res => {
          this.produtos = res.data;
        })
        .catch(console.error);
      },
      deleteItem(produto){
        produtoRepo.delete(produto.id).then(() => {
          this.loadprodutos();
        })
        .catch(console.error);
      },
      addItem(){
        this.$router.push('/cadastrarProduto')
      },
      editItem(item){
        this.$router.push({name: 'CadastrarProduto', params: { data: item}});  
      }
    }
  };
  </script>
  