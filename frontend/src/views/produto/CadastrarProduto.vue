<template>
  <div>
    <v-card-widget enableActions :title="!this.$route.params.data ? 'Cadastrar Produto' : 'Atualizar Produto' ">
      <div slot="widget-header-action"></div>
      <div slot="widget-content">
        <v-row>
          <v-col cols="12" md="4">
            <h1></h1>
            <v-text-field v-model="produto.nome" label="Nome do Produto" required></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field v-model="produto.descricao" label="Descrição do Produto" required></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field v-model="produto.marca" label="Marca do Produto" required></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-btn @click="voltar" color="primary" >Voltar</v-btn>
          </v-col>
          <v-col align="right">
            <v-btn color="primary" dark dense app @click="cadastrarProduto">Salvar</v-btn>
          </v-col>
        </v-row>
      </div>
    </v-card-widget>
  </div>
</template>
<script type = “text/javascript” src = “js/vue.js”></script>
<script>
import { validationMixin } from "vuelidate";
import { required } from "vuelidate/lib/validators";
import VCardWidget from "@/components/VWidget";

export default {
  mixins: [validationMixin],

  components: {
    VCardWidget
  },

  validations: {
    nomeProduto: { required },
    descricaoProduto: { required },
    marcaProduto: { required }
  },
  data() {
    return {
      produto: {}
    }
  },
  created(){
  },

  computed: {
  },

  watch: {
  },

  methods: {
    cadastrarProduto() {
      if(this.$route.params.data){
        console.log("update");
        console.log(this.$route.params.data);
        this.produto.id= this.$route.params.data.id;
        this.$store.dispatch("produto/updateProduto", this.produto);
      }
      else{
        this.$store.dispatch("produto/createProduto", this.produto);
        this.$router.push('/listarProdutos')
      }
    },
    voltar(){
      this.$router.push('/listarProdutos')
    }
  }
};
</script>

<style>
</style>