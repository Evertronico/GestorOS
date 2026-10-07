package br.edu.fasm.gestoros;

import br.edu.fasm.gestoros.dao.ClienteDao;
import br.edu.fasm.gestoros.dao.Dao;
import br.edu.fasm.gestoros.model.Cliente;

/**
 * Ponto de entrada do GestorOS.
 *
 * O cadastro de clientes deixa de acontecer direto numa lista do main e
 * passa a acontecer atraves de um Dao<Cliente>. O main so conhece a
 * interface Dao - nao sabe, e nao precisa saber, que por baixo dela existe
 * uma lista em memoria.
 */
public class GestorOS {

    public static void main(String[] args) {
        Dao<Cliente> clienteDao = new ClienteDao();

        clienteDao.salvar(new Cliente("Joao", "(32) 98811-4402"));
        clienteDao.salvar(new Cliente("Maria", "(32) 99123-7788"));
        Cliente descartado = clienteDao.salvar(new Cliente("Cliente de Teste", "(32) 90000-0000"));

        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clienteDao.listarTodos()) {
            System.out.println("    #" + cliente.getId() + " " + cliente);
        }

        System.out.println("\nBusca por id 2 .: " + clienteDao.buscarPorId(2));

        clienteDao.remover(descartado.getId());
        System.out.println("\nApos remover #" + descartado.getId() + ":");
        for (Cliente cliente : clienteDao.listarTodos()) {
            System.out.println("    #" + cliente.getId() + " " + cliente);
        }

        // Continua valendo: o objeto invalido nao chega a nascer.
        try {
            clienteDao.salvar(new Cliente("Jo", ""));
        } catch (IllegalArgumentException e) {
            System.out.println("\nRecusado ...: " + e.getMessage());
        }
    }
}
