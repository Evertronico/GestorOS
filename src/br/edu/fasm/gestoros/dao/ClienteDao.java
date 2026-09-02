package br.edu.fasm.gestoros.dao;

import br.edu.fasm.gestoros.model.Cliente;

/**
 * Primeira implementacao concreta do contrato Dao<T>.
 *
 * Nao repete nenhuma logica de salvar, buscar, listar ou remover - tudo
 * isso ja existe em DaoBase. ClienteDao so ensina o que e exclusivo de
 * Cliente: onde fica o identificador.
 */
public class ClienteDao extends DaoBase<Cliente> {

    @Override
    protected void definirId(Cliente objeto, int id) {
        objeto.setId(id);
    }

    @Override
    protected int idDe(Cliente objeto) {
        return objeto.getId();
    }
}