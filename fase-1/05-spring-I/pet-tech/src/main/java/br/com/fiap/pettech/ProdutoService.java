package br.com.fiap.pettech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(UUID id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        produto = produtoRepository.save(produto);
        return produto;
    }

    public Produto update(UUID id, Produto produto) {
        Produto produtoSelecionado = produtoRepository.getOne(id);
        produtoSelecionado.setNome(produto.getNome());
        produtoSelecionado.setDescricao(produto.getDescricao());
        produtoSelecionado.setPreco(produto.getPreco());
        produtoSelecionado.setUrlImagem(produto.getUrlImagem());
        produtoSelecionado = produtoRepository.save(produtoSelecionado);
        return produtoSelecionado;
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

}
