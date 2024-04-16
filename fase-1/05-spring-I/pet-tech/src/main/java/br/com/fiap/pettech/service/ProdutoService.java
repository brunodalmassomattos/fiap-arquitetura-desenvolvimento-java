package br.com.fiap.pettech.service;

import br.com.fiap.pettech.controller.exception.ControllerNotFoundException;
import br.com.fiap.pettech.dto.ProdutoDTO;
import br.com.fiap.pettech.entity.Produto;
import br.com.fiap.pettech.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(this::toProdutoDTO).collect(Collectors.toList());
    }

    public ProdutoDTO findById(UUID id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
        return toProdutoDTO(produto);
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        return toProdutoDTO(produtoRepository.save(toProduto(produtoDTO)));
    }

    public ProdutoDTO update(UUID id, ProdutoDTO produtoDTO) {
        try {
            Produto produtoSelecionado = produtoRepository.getReferenceById(id);
            produtoSelecionado.setNome(produtoDTO.nome());
            produtoSelecionado.setDescricao(produtoDTO.descricao());
            produtoSelecionado.setPreco(produtoDTO.preco());
            produtoSelecionado.setUrlImagem(produtoDTO.urlImagem());
            produtoSelecionado = produtoRepository.save(produtoSelecionado);

            return toProdutoDTO(produtoSelecionado);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

    private ProdutoDTO toProdutoDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getUrlImagem());
    }

    private Produto toProduto(ProdutoDTO produtoDTO) {
        return new Produto(
                produtoDTO.id(),
                produtoDTO.nome(),
                produtoDTO.descricao(),
                produtoDTO.preco(),
                produtoDTO.urlImagem());
    }

}
