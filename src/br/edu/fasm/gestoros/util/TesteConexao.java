package br.edu.fasm.gestoros.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Programa isolado desta aula: só prova que o canal com o MySQL abre e
 * fecha corretamente. Não toca em Cliente, Dao ou DaoBase - o main do
 * GestorOS continua rodando exatamente como na Aula 05.
 */
public class TesteConexao {

    public static void main(String[] args) {
        try (Connection conexao = ConexaoMySQL.obter();
             Statement comando = conexao.createStatement();
             ResultSet resultado = comando.executeQuery("SELECT 1")) {

            if (resultado.next()) {
                System.out.println("Conexão com o MySQL funcionando. Retorno: " + resultado.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao MySQL: " + e.getMessage());
        }
    }
}
