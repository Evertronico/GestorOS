package br.edu.fasm.gestoros.model;

/**
 * Cliente da assistencia tecnica.
 *
 * A classe representa uma coisa do mundo real, nao uma tela nem uma tabela.
 * Os atributos sao privados: o acesso ocorre por metodos publicos.
 * A validacao dos dados entra na Aula 02, junto com encapsulamento.
 */
public class Cliente {

    private int id;
    private String nome;
    private String telefone;

    // O construtor exige o que o objeto precisa para existir.
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}
