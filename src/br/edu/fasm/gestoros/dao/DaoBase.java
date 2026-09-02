package br.edu.fasm.gestoros.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacao em memoria, comum a qualquer Dao<T>.
 *
 * DaoBase e abstrata porque nao sabe ler nem gravar o identificador de T -
 * Cliente usa getId/setId, OrdemServico tambem, mas nada garante que todo T
 * futuro siga esse mesmo padrao. Por isso definirId e idDe ficam como
 * metodos abstratos: cada subclasse concreta ensina a DaoBase a enxergar o
 * identificador do seu proprio T, e o CRUD generico e escrito uma unica vez.
 *
 * A lista em memoria e a representacao de hoje. Na Aula 06 uma nova
 * implementacao de Dao<T> troca esta lista por uma tabela do MySQL, e
 * nenhuma tela do GestorOS percebe a diferenca - o mesmo principio do TAD
 * ja visto em Estrutura de Dados: o contrato e publico, a representacao e
 * detalhe interno.
 */
public abstract class DaoBase<T> implements Dao<T> {

    private final List<T> registros = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public T salvar(T objeto) {
        definirId(objeto, proximoId);
        registros.add(objeto);
        proximoId++;
        return objeto;
    }

    @Override
    public T buscarPorId(int id) {
        for (T registro : registros) {
            if (idDe(registro) == id) {
                return registro;
            }
        }
        return null;
    }

    @Override
    public List<T> listarTodos() {
        return List.copyOf(registros);
    }

    @Override
    public void remover(int id) {
        registros.removeIf(registro -> idDe(registro) == id);
    }

    /** Ensina a DaoBase a atribuir o identificador gerado a um T concreto. */
    protected abstract void definirId(T objeto, int id);

    /** Ensina a DaoBase a ler o identificador de um T concreto. */
    protected abstract int idDe(T objeto);
}