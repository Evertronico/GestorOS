package br.edu.fasm.gestoros.dao;

import br.edu.fasm.gestoros.exception.PersistenciaException;
import br.edu.fasm.gestoros.model.Cliente;
import br.edu.fasm.gestoros.util.ConexaoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementacao de Dao<Cliente> sobre a tabela clientes do MySQL.
 *
 * Na Aula 05, ClienteDao estendia DaoBase e reaproveitava o CRUD em lista.
 * Uma tabela nao se comporta como uma lista em memoria - cada operacao
 * agora abre uma conexao, monta um comando SQL e trata a possibilidade
 * real de falha (rede, banco fora do ar). Por isso ClienteDao deixa de
 * estender DaoBase e passa a implementar Dao<Cliente> diretamente: o que
 * continua igual é o contrato (Dao<T>), nao a implementacao.
 */
public class ClienteDao implements Dao<Cliente> {

    @Override
    public Cliente salvar(Cliente objeto) {
        String sql = "INSERT INTO clientes (nome, telefone) VALUES (?, ?)";
        try (Connection conexao = ConexaoMySQL.obter();
             PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            comando.setString(1, objeto.getNome());
            comando.setString(2, objeto.getTelefone());
            comando.executeUpdate();
            try (ResultSet chaves = comando.getGeneratedKeys()) {
                if (chaves.next()) {
                    objeto.setId(chaves.getInt(1));
                }
            }
            return objeto;
        } catch (SQLException e) {
            throw new PersistenciaException("Não foi possível salvar o cliente " + objeto.getNome(), e);
        }
    }

    @Override
    public Cliente atualizar(Cliente objeto) {
        String sql = "UPDATE clientes SET nome = ?, telefone = ? WHERE id = ?";
        try (Connection conexao = ConexaoMySQL.obter();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, objeto.getNome());
            comando.setString(2, objeto.getTelefone());
            comando.setInt(3, objeto.getId());
            comando.executeUpdate();
            return objeto;
        } catch (SQLException e) {
            throw new PersistenciaException("Não foi possível alterar o cliente #" + objeto.getId(), e);
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT id, nome, telefone FROM clientes WHERE id = ?";
        try (Connection conexao = ConexaoMySQL.obter();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            try (ResultSet resultado = comando.executeQuery()) {
                return resultado.next() ? construir(resultado) : null;
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Não foi possível buscar o cliente #" + id, e);
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT id, nome, telefone FROM clientes ORDER BY id";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conexao = ConexaoMySQL.obter();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {
            while (resultado.next()) {
                clientes.add(construir(resultado));
            }
            return clientes;
        } catch (SQLException e) {
            throw new PersistenciaException("Não foi possível listar os clientes", e);
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conexao = ConexaoMySQL.obter();
             PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Não foi possível remover o cliente #" + id, e);
        }
    }

    private Cliente construir(ResultSet resultado) throws SQLException {
        Cliente cliente = new Cliente(resultado.getString("nome"), resultado.getString("telefone"));
        cliente.setId(resultado.getInt("id"));
        return cliente;
    }
}
