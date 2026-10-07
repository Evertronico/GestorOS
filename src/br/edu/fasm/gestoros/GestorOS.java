package br.edu.fasm.gestoros;

import javax.swing.SwingUtilities;


/**
 * Ponto de entrada do GestorOS.
 *
 * O terminal deixa de ser a interface do sistema: main() agora só abre a
 * TelaPrincipal, na thread de eventos do Swing (SwingUtilities.invokeLater)
 * - é essa thread, e não a main, que deve tocar em qualquer componente da
 * interface daqui para frente.
 */
public class GestorOS {

    public static void main(String[] args) {

    }
}
