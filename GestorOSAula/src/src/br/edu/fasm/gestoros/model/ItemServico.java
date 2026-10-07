package br.edu.fasm.gestoros.model;

import java.math.BigDecimal;

/**
 * Item lancado dentro de uma Ordem de Servico (mao de obra ou peca aplicada).
 * 
 * ItemServico e a parte de uma relacao de composicao: nao existe fora de 
 * uma OrdeServico, nao tem sentido de dominio isolado e nao carrega
 * referencia de volta para a ordem que o contem. Se a ordem for descartada,
 * os itens sao descartados juntos.
 */
public class ItemServico {

    private String descricao;
    private BigDecimal valor;

    public ItemServico(String descricao, BigDecimal valor) {
        setDescricao(descricao);
        setValor(valor);
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição do item é obrigatória");
        }
        this.descricao = descricao.trim();
    }

    public final void setValor(BigDecimal valor) {
        if (valor == null || valor.signum() < 0) {
            throw new IllegalArgumentException("Valor do item não pode ser negativo");
        }
        this.valor = valor;
    }

    public String getDescricao() { return descricao; }
    public BigDecimal getValor() { return valor; }

    @Override
    public String toString() {
        return descricao + " (R$ " + valor + ")";
    }
}