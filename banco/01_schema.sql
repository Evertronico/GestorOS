-- Aula 06 — esquema inicial do GestorOS.
-- Cada coluna espelha um atributo encapsulado da classe Cliente.

CREATE DATABASE IF NOT EXISTS gestoros;

USE gestoros;

CREATE TABLE IF NOT EXISTS clientes (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(120) NOT NULL,
    telefone  VARCHAR(20)  NOT NULL
);
