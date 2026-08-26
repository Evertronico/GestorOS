package br.edu.fasm.gestoros.model;

/**
 * Cliente da assistencia tecnica.
 *
 * Id, nome, telefone e a validação dos dois últimos agora vivem em 
 * Pessoa. Cliente só acrescenta o que é exclusivamente seu - por
 * enquanto, nada além de dizer, via getPapel(), o que ele é.
 */
public class Cliente extends Pessoa {

    public Cliente(String nome, String telefone) {
        super(nome, telefone);
    }

    @Override
    public String getPapel() {
        return "Cliente";
    }
}
