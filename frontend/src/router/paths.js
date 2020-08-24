
//import LoginPage from '../views/Login'
import Home from '../views/Home'
import ListarProdutos from '../views/produto/ListarProdutos'
import CadastrarLoja from '../views/loja/CadastrarLoja'
import CadastrarProduto from '../views/produto/CadastrarProduto'
import ListarProdutosLoja from '../views/produtosLoja/ListarProdutosLoja'
import AdicionarProdutoLoja from '../views/produtosLoja/AdicionarProdutoLoja'
export default [


    /* Geral */
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    /*{
        path: '/login',
        meta: {
            public: true,
        },
        props: true,
        name: 'Login',
        component: LoginPage
    },*/
    {
        path: '/listarProdutos',
        name: 'ListarProdutos',
        component: ListarProdutos
    },
    {
        path: '/adicionarProdutoLoja',
        name: 'AdicionarProdutoLoja',
        component: AdicionarProdutoLoja
    },
    {
        path: '/listarProdutosLoja',
        name: 'ListarProdutosLoja',
        component: ListarProdutosLoja
    },
    {
        path: '/cadastrarLoja',
        name: 'CadastrarLoja',
        component: CadastrarLoja
    },
    {
        path: '/cadastrarProduto',
        name: 'CadastrarProduto',
        component: CadastrarProduto
    },
    /*{
        path: '/logout',
        meta: { breadcrumb: true },
        name: 'Logout',
    },*/

];
