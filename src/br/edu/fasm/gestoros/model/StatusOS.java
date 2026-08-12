package br.edu.fasm.gestoros.model;

/**
 * Estados possiveis de uma Ordem de Servico.
 *
 * O estado da OS e um conjunto FECHADO de valores. Usar enum, e nao String,
 * leva ao compilador a checagem que o texto livre nao faz: nao existe
 * StatusOS.CONCLUIDAA, mas existe a String "Concluidaa".
 */
public enum StatusOS {
    ABERTA,
    EM_ANALISE,
    EM_EXECUCAO,
    CONCLUIDA,
    ENTREGUE,
    CANCELADA
}
