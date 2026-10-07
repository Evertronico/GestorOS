package br.edu.fasm.gestoros.model;

/**
 * Técnico da assistência técnica, responsável por executar as Oedens de
 * Serviço. Compartilha id, nome e o telefone com Cliente via Pessoa; a
 * especialidade é o que só Técnico tem.
 */
public class Tecnico extends Pessoa {

    private String especialidade;

    public Tecnico(String nome, String telefone, String especialidade) {
        super(nome, telefone);
        setEspecialidade(especialidade);
    }

    public final void setEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.trim().isBlank()) {
            throw new IllegalArgumentException("Especialidade é obrigatória.");
        }
        this.especialidade = especialidade.trim();
    }

    public String getEspecialidade() { return especialidade; }

    @Override
    public String getPapel() {
        return "Técnico";
    }

    @Override
    public String toString() {
        return super.toString() + " (especialidade: " + especialidade + ")";
    }
}