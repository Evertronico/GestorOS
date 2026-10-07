package br.edu.fasm.gestoros.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Ponto único de abertura de conexão com o MySQL.
 * 
 * URL, usuário e senha ficam concentradas aqui - nenhuma outra classe
 * do GestorOS precisa conhecer esses detalhes. Ainda não é usada por 
 * nenhum Dao<T>: a AUla 05 deixou DaoBase guardando registros em memória,
 * e isso continua assim até a Aula 07 trocar essa lista por um SQL de verdade.
 */
public final class ConexaoMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/gestoros";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    private ConexaoMySQL() {
        // Classe utilitária: só métodos estáticos, nenhuma instância.
    }

    public static Connection obter() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}