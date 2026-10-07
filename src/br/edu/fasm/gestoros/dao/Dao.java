package br.edu.fasm.gestoros.dao;

import java.util.List;

/**
 * Contrato de persistencia, comum a toda entidade do GestorOS.
 *
 * Uma interface nao guarda estado e nao entrega implementacao: apenas
 * declara o que uma classe promete fazer. Qualquer camada que dependa de
 * Dao<T> pode trocar a implementacao concreta - hoje em memoria, na Aula 06
 * em MySQL - sem que uma linha fora do pacote dao precise mudar.
 *
 * T e um parametro de tipo: o mesmo contrato serve para Cliente, Tecnico
 * ou OrdemServico sem reescrever a interface para cada um.
 */
public interface Dao<T> {

    T salvar(T objeto);

    T buscarPorId(int id);

    List<T> listarTodos();

    void remover(int id);
}