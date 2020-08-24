<template>
  <div>
    <v-card-widget enableActions :title="'Página Inicial - Lojas'">
      <div slot="widget-header-action"></div>
      <div slot="widget-content">
        <v-row>
          <v-col cols="12">
            <v-data-table
              :headers="headers"
              :items="lojas"
              :items-per-page="5"
              class="elevation-1"
              @click:row="goToProducts"
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
const lojaRepo = RepositoryFactory.get("loja");

export default {
  name: "home",
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
      { text: "Endereço", value: "endereco" },
      { text: "", value: "actions", sortable: false }
    ],
    lojas: []
  }),

  created() {
    lojaRepo
      .getAll()
      .then(res => {
        this.lojas = res.data;
      })
      .catch(console.error);
  },

  computed: {},

  methods: {
    loadlojas(){
      lojaRepo
      .getAll()
      .then(res => {
        this.lojas = res.data;
      })
      .catch(console.error);
    },
    deleteItem(loja){
      lojaRepo.delete(loja.id).then(() => {
        this.loadlojas();
      })
      .catch(console.error);
    },
    addItem(){
      this.$router.push('/cadastrarLoja')
    },
    editItem(item){
        this.$router.push({name: 'CadastrarLoja', params: { data: item}});  
    },
    goToProducts(value){
      this.$router.push({name: 'ListarProdutosLoja', params: { data: value}});
    }
  }
};
</script>
