package br.edu.fasm.gestoros;

import br.edu.fasm.gestoros.model.Cliente;
import br.edu.fasm.gestoros.model.Equipamento;
import br.edu.fasm.gestoros.model.ItemServico;
import br.edu.fasm.gestoros.model.OrdemServico;
import java.math.BigDecimal;

/**
 * Ponto de entrada do GestorOS.
 *
 * Nesta aula o main demonstra os dois relacionamentos que o modelo agora
 * expressa: Equipamento associa-se a Cliente por referencia de objeto, e
 * OrdemServico compoe uma lista de ItemServico que so existe dentro dela.
 */
public class GestorOS {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Marina Alvarenga", "(32) 98811-4402");
        cliente.setId(1);

        // Associacao: o equipamento guarda uma referencia direta ao cliente.
        Equipamento equip = new Equipamento(cliente, "Notebook", "Acer",
            "Nao liga apos queda de energia");
        equip.setId(1);

        // Composicao: os itens abaixo so existem porque esta OS existe.
        OrdemServico os = new OrdemServico(cliente, equip);
        os.setId(1);
        os.adicionarItem(new ItemServico("Fonte 65W", new BigDecimal("149.90")));
        os.adicionarItem(new ItemServico("Mao de obra - diagnostico", new BigDecimal("80.00")));
        os.adicionarItem(new ItemServico("Limpeza interna", new BigDecimal("40.00")));

        System.out.println("Cliente ....: " + cliente);
        System.out.println("Equipamento : " + equip);
        System.out.println("Ordem de Servico: " + os);
        System.out.println("Total dos itens .: R$ " + os.calcularTotal());

        // O objeto invalido nao nasce: a excecao interrompe a construcao.
        try {
            new Equipamento(null, "Notebook", "Acer", "Nao liga");
        } catch (IllegalArgumentException e) {
            System.out.println("Recusado ...: " + e.getMessage());
        }
    }
}