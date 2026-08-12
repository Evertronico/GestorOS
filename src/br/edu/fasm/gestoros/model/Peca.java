package br.edu.fasm.gestoros.model;

import java.math.BigDecimal;

/**
 * Peca do catalogo, usada nos servicos.
 *
 * Valor monetario usa BigDecimal, e nao double: double e binario e nao
 * representa 0,10 com exatidao, o que produz centavos perdidos em somas.
 */
public class Peca {

    private int id;
    private String nome;
    private BigDecimal preco;

    public Peca(String nome, BigDecimal preco) {
        setNome(nome);
        setPreco(preco);
    }

    public final void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da peca e obrigatorio.");
        }
        this.nome = nome.trim();
    }

    public final void setPreco(BigDecimal preco) {
        // Invariante do dominio: preco nunca e negativo.
        if (preco == null || preco.signum() < 0) {
            throw new IllegalArgumentException("Preco nao pode ser negativo.");
        }
        this.preco = preco;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public BigDecimal getPreco() { return preco; }

    @Override
    public String toString() {
        return nome + " (R$ " + preco + ")";
    }
}
