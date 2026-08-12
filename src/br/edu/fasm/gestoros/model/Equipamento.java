package br.edu.fasm.gestoros.model;

/**
 * Equipamento deixado pelo cliente para conserto.
 *
 * O vinculo com o cliente ainda e o identificador dele. A associacao entre
 * objetos, com referencia direta a Cliente, e assunto da Aula 03.
 */
public class Equipamento {

    private int id;
    private int idCliente;
    private String tipo;
    private String marca;
    private String defeito;

    public Equipamento(int idCliente, String tipo, String marca, String defeito) {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("Equipamento precisa de um cliente.");
        }
        this.idCliente = idCliente;
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
    public int getIdCliente() { return idCliente; }
    public String getTipo() { return tipo; }
    public String getMarca() { return marca; }
    public String getDefeito() { return defeito; }

    @Override
    public String toString() {
        return tipo + " " + marca;
    }
}
