package br.edu.fasm.gestoros.exception;

/**
 * Exceção de negócio própria: traduz qualquer falha de acesso a dados
 * (hoje, SQLException) para um tipo que o resto do sistema entende, sem
 * precisar conhecer java.sql. Não verificada (RuntimeException) porque a
 * assinatura de Dao<T> não declara throws — quem chama salvar/buscarPorId
 * não é obrigado a lidar com um detalhe de JDBC que talvez nem exista
 * numa implementação futura em memória.
 */
public class PersistenciaException extends RuntimeException {

    public PersistenciaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
