package br.edu.fasm.gestoros;

import br.edu.fasm.gestoros.model.Cliente;
import br.edu.fasm.gestoros.model.Equipamento;
import br.edu.fasm.gestoros.model.Peca;
import java.math.BigDecimal;

/**
 * Ponto de entrada do GestorOS.
 *
 * Nesta aula o main serve para demonstrar que as entidades se defendem:
 * dados validos criam objetos; dados invalidos nao chegam a existir.
 */
public class GestorOS {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Marina Alvarenga", "(32) 98811-4402");
        cliente.setId(1);

        Equipamento equip = new Equipamento(cliente.getId(), "Notebook", "Acer",
                                            "Nao liga apos queda de energia");
        Peca peca = new Peca("Fonte 65W", new BigDecimal("149.90"));

        System.out.println("Cliente ....: " + cliente);
        System.out.println("Equipamento : " + equip);
        System.out.println("Peca .......: " + peca);

        // O objeto invalido nao nasce: a excecao interrompe a construcao.
        try {
            new Cliente("Jo", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Recusado ...: " + e.getMessage());
        }
    }
}
