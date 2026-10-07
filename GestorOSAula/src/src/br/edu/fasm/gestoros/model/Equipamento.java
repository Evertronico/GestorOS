package br.edu.fasm.gestoros.model;

/**
 * Equipamento deixado pelo cliente para conserto.
 *
 * O vinculo com o cliente agora e uma associacao: o campo guarda uma
 * referencia direta ao objeto Cliente, nao mais a um numero solto. O
 * equipamento nao possui o cliente, apenas aponta para ele; o cliente
 * continua existindo mesmo que o equipamento seja descartado
 */
public class Equipamento {

    private int id;
    private Cliente cliente;
    private String tipo;
    private String marca;
    private String defeito;

    public Equipamento(Cliente cliente, String tipo, String marca, String defeito) {
        if (cliente == null) {
            throw new IllegalArgumentException("Equipamento precisa de um cliente.");
        }
        this.cliente = cliente;
        setTipo(tipo);
        this.marca = marca;
        setDefeito(defeito);
    }

    public final void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Tipo do equipamento e obrigatorio.");
        }
        this.tipo = tipo.trim();
    }

    public final void setDefeito(String defeito) {
        if (defeito == null || defeito.isBlank()) {
            throw new IllegalArgumentException("Defeito relatado e obrigatorio.");
        }
        this.defeito = defeito.trim();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public String getTipo() { return tipo; }
    public String getMarca() { return marca; }
    public String getDefeito() { return defeito; }

    @Override
    public String toString() {
        return tipo + " " + marca;
    }
}
