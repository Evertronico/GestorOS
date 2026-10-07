package br.edu.fasm.gestoros.model;

public abstract class Pessoa {

    private int id;
    private String nome;
    private String telefone;

    protected Pessoa(String nome, String telefone) {
        // O construtor delega ao setter: a regra fica escrita em um lugar só.
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
        if (telefone == null || telefone.isBlank() || telefone.trim().length() < 10) {
            throw new IllegalArgumentException("telefone é obrigatório");
        }
        this.telefone = telefone.trim();
    }

    // Sem corpo: cada subclasse decide o que devolver, o compilador exige.
    public abstract String getPapel();

    // Sem setter para id: quem define o identificador é o banco, na aula 06.
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return getPapel() + ": " + nome + " - " + telefone;
    }
}