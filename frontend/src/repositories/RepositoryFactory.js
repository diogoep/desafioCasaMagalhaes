import LojaRepository from "./LojaRepository"
import ProdutoRepository from "./ProdutoRepository"
import ProdutosLojaRepository from "./ProdutosLojaRepository"

const repositories = {
    loja: LojaRepository,
    produto: ProdutoRepository,
    produtosLoja: ProdutosLojaRepository
};

export const RepositoryFactory = {
    get: name => repositories[name]
};
