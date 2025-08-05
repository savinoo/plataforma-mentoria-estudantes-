package br.edu.iff.ccc.plataforma_mentoria.controller.apirest;

import org.springframework.web.bind.annotation.*;

import br.edu.iff.ccc.plataforma_mentoria.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoRestController {

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable("id") Long id) {
        // Simula a busca de um produto
        return new Produto(id, "Produto " + id, "Descrição do produto " + id, 100.0 * id);
    }

    @PostMapping
    public void createProduto(@RequestParam String nome, @RequestParam String descricao, @RequestParam double preco) {
        System.out.println("Produto recebido:");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: " + preco);
    }
}
