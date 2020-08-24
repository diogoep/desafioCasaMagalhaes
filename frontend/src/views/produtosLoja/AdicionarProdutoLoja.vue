<template>
  <div>
    <v-card-widget enableActions :title="!this.$route.params.data ? 'Cadastrar Produto' : 'Atualizar Produto' ">
      <div slot="widget-header-action"></div>
      <div slot="widget-content">
        <v-row>
          <v-col cols="12" md="4">
            <h1></h1>
            <v-select :items="produtos" item-text="nome" item-value="id" return-object v-model="produtoLoja.produto"></v-select>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field type="number" v-model="produtoLoja.quantidade" label="Quantidade do Produto" required></v-text-field>
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
  import { RepositoryFactory } from "@/repositories/RepositoryFactory";
  const produtoRepo = RepositoryFactory.get("produto");
export default {
  mixins: [validationMixin],

  components: {
    VCardWidget
  },

  validations: {
    quantidade: { required },
    produto: { required },
  },
  data() {
    return {
        produtos: [],
        produtoLoja: {}
    }
  },
  created(){
       produtoRepo
        .getAll()
        .then(res => {
          this.produtos = res.data;
        })
        .catch(console.error);
  },

  computed: {
  },

  watch: {
  },

  methods: {
      loadprodutos(){
        produtoRepo
        .getAll()
        .then(res => {
          this.produtos = res.data;
        })
        .catch(console.error);
      },
    cadastrarProduto() {
      if(this.$route.params.data.produto){
        this.produtoLoja.idLoja = this.$route.params.data.loja.id;
        this.produtoLoja.idProduto = this.$route.params.data.produto.id;
        this.produtoLoja.produto = this.$route.params.data.produto;
        this.$store.dispatch("produtoLoja/updateProdutoLoja", this.produtoLoja);
      }
      else{
        this.produtoLoja.idLoja = this.$route.params.data.id;
        this.$store.dispatch("produtoLoja/createProdutoLoja", this.produtoLoja);
      }
    },
    voltar(){
      this.$router.push('/')
    }
  }
};
</script>

<style>
</style>