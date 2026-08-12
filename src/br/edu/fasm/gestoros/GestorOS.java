package br.edu.fasm.gestoros;

import br.edu.fasm.gestoros.model.Cliente;
import br.edu.fasm.gestoros.model.StatusOS;

/**
 * Ponto de entrada do GestorOS.
 *
 * Hoje so prova que o ambiente compila e executa e que as entidades ja
 * modelam o problema. Ao fim do semestre esta classe apenas abrira a
 * janela principal da aplicacao.
 */
public class GestorOS {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Marina Alvarenga", "(32) 98811-4402");
        cliente.setId(1);

        System.out.println("Cliente ...........: " + cliente);
        System.out.println("Status inicial da OS: " + StatusOS.ABERTA);
    }
}
