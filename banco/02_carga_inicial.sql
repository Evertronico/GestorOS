-- Aula 06 — carga inicial da tabela clientes.
-- Mesmos dois clientes que o main de GestorOS.java cadastra em memória
-- desde a Aula 05; nenhum Dao ainda lê esta tabela (isso é Aula 07).

USE gestoros;

INSERT INTO clientes (nome, telefone) VALUES
    ('Marina Alvarenga', '(32) 98811-4402'),
    ('Bruno Kalil', '(32) 99123-7788');
