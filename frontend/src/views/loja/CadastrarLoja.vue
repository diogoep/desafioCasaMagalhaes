<template>
  <div>
    <v-card-widget enableActions :title="!this.$route.params.data ? 'Cadastrar Loja' : 'Atualizar Loja' ">
      <div slot="widget-header-action"></div>
      <div slot="widget-content">
        <v-row>
          <v-col cols="12" md="4">
            <v-text-field v-model="loja.nome" label="Nome da Loja" required></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field v-model="loja.endereco" label="Endereço da Loja" required></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-btn @click="voltar" color="primary" >Voltar</v-btn>
          </v-col>
          <v-col align="right">
            <v-btn color="primary" dark dense app @click="cadastrarLoja">Salvar</v-btn>
          </v-col>
        </v-row>
      </div>
    </v-card-widget>
  </div>
</template>

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
    nomeLoja: { required },
    enderecoLoja: { required }
  },
  data() {
    return {
      loja: {},
    };
  },

  computed: {
    nomeErrors() {
      const errors = [];
      if (!this.$v.nome.$dirty) return errors;
      !this.$v.nome.required && errors.push("Nome é obrigatório.");
      return errors;
    },
    enderecoErrors() {
      const errors = [];
      if (!this.$v.endereco.$dirty) return errors;
      !this.$v.endereco.required && errors.push("Endereço é obrigtório");
      return errors;
    }
  },

  methods: {
    cadastrarLoja() {
      if(this.$route.params.data){
        //console.log("update");
        //console.log(this.$route.params.data.id);
        this.loja.id = this.$route.params.data.id;
        this.$store.dispatch("loja/updateLoja", this.loja);
      }
      else{
        this.$store.dispatch("loja/createLoja", this.loja);
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