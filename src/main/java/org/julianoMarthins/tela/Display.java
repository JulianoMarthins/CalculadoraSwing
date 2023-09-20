package org.julianoMarthins.tela;

import org.julianoMarthins.modelo.Memoria;
import org.julianoMarthins.modelo.Observador;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Display extends JPanel implements Observador {
    /*
    Jpanel é uma classe conhecida como 'Conteiners' onde é utilizada para axuliar a criação de telas mais complexas.
    No casso deste programa, podemos programar diferentes elementos gráficos dividos em classes e com a ajuda do Jpanel
    unir organizadamente todos os elementos gráficos em uma tela.

    Está classe é responsável pelo display gráfico da calculadora.
     */

    //Atributos de classe
    private final JLabel label;

    public Display() {
        Memoria.getInstancia().addObservador(this::valorAlterado);

        setBackground(new Color(46, 49, 50)); // Insere cor personalizada ao display
        label = new JLabel(Memoria.getInstancia().getTextoAtual()); // Pega da memória o valor armazenado
        label.setForeground(Color.WHITE); // Altera a cor da fonte

        /*
        A linha de código abaixo configurará a fonte do display, A instanciação de uma nova fonte passa como argumentos
        qual fonte usar, neste casso a fonte escolida é 'courier', o código Font.PLAIN é refenrete a deixar a fonte
        escolhida em negrito e o valor '30' é o tamanho da fonte.
         */
        label.setFont(new Font("courier", Font.PLAIN, 30));

        /*
        O código abaixo usa a classe FlowLayout passando ele mesmo como argumento para chamar o método correspondente
        ao local que você deseja deixar a visibilidade dos números no layout. É chamado o próprio FlowLayout como seu
        argumento porque existem métodos que pré definem onde ficará esta visibilidade, sendo este método, convertido
        para um valor inteiro pois, na reailidade, a classe FlowLayout espera números inteiros para setar o local da
        fonte no display do nosso programa.
        Recebendo também como argumento temos o 'hgap' e o 'vgap', que seria o espaçamento lateral e vertical do valor
        númerico apresentado no display
         */
        setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 25));


        add(label); // Adiciona o label criado ao JFrame


    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
