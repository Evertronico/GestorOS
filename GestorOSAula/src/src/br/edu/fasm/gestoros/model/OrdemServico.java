package br.edu.fasm.gestoros.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Ordem de Servico: o registro central do conserto.
 *
 * OrdemServico associa Cliente e Equipamento (referencias a objetos que
 * existem por conta propria, antes e depois da OS) e compoe uma lista de
 * ItemServico (objetos que nascem dentro da OS e nao sobrevivem sozinhos
 * fora dela). A lista e privada e exposta apenas como copia somada, nunca
 * como referencia direta, para que ninguem altere os itens por fora.
 */
public class OrdemServico {

    private int id;
    private Cliente cliente;
    private Equipamento equipamento;
    private StatusOS status;
    private final List<ItemServico> itens = new ArrayList<>();

    public OrdemServico(Cliente cliente, Equipamento equipamento) {
        if (cliente == null || equipamento == null) {
            throw new IllegalArgumentException("OS precisa de cliente e equipamento.");
        }
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.status = StatusOS.ABERTA;
    }

    public void adicionarItem(ItemServico item) {
        // O item so existe amarrado a uma OS: nao ha metodo que o devolva solto.
        if (item == null) {
            throw new IllegalArgumentException("Item nao pode ser nulo.");
        }
        itens.add(item);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemServico item : itens) {
            total = total.add(item.getValor());
        }
        return total;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public Equipamento getEquipamento() { return equipamento; }
    public StatusOS getStatus() { return status; }
    public void setStatus(StatusOS status) { this.status = status; }
    public List<ItemServico> getItens() { return List.copyOf(itens); }

    @Override
    public String toString() {
        return "OS #" + id + " - " + cliente.getNome() + " - " + status
            + " - total R$ " + calcularTotal();
    }
}