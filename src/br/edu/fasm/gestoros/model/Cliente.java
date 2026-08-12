package br.edu.fasm.gestoros.model;

/**
 * Cliente da assistencia tecnica.
 *
 * Encapsulamento: os atributos sao privados e so mudam por metodos que
 * validam o valor recebido. Assim o objeto nunca entra em estado invalido.
 *
 * Os setters sao final porque o construtor os chama: um metodo sobrescrito
 * por uma subclasse rodaria antes de a subclasse estar pronta.
 */
public class Cliente {

    private int id;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        // O construtor delega ao setter: a regra fica escrita em um lugar so.
        setNome(nome);
        setTelefone(telefone);
    }

    public final void setNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome deve ter ao menos 3 caracteres.");
        }
        this.nome = nome.trim();
    }

    public final void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone e obrigatorio.");
        }
        this.telefone = telefone.trim();
    }

    // Sem setter para id: quem define o identificador e o banco, na Aula 06.
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}
