package org.julianoMarthins.tela;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Teclado extends JPanel {

    private final Color corCinzaEscuro = new Color(68, 68, 68);
    private final Color corCinzaClaro = new Color(99, 99, 99);
    private final Color corLaranja = new Color(242, 163, 60);


    /*
    Jpanel é uma classe conhecida como 'Conteiners' onde é utilizada para axuliar a criação de telas mais complexas.
    No casso deste programa, podemos programar diferentes elementos gráficos dividos em classes e com a ajuda do Jpanel
    unir organizadamente todos os elementos gráficos em uma tela.

    Está classe é responsavel pela criação do teclado numérico da calculadora.
     */


    public Teclado(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();

        setLayout(layout);

        /*
        Os códigos weight x e weighty colocam peso nas linhas x e y respectivamente, recebendo o valor inteiro
        1, ele preenche 100% da tela disponível nos eixos x, y.

        O código .fill, recebendo o método BOTH de GridBagConstraints une todos os botões eliminando os espaços
        entre eles.
         */
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH; // Método faz os botoes ficarem todos juntos.

        // Linha 01
        cons.gridwidth = 2;
        adicionarBotao("AC", corCinzaEscuro, cons, 0, 0);
        cons.gridwidth = 1;
        adicionarBotao("%", corCinzaEscuro, cons, 0, 2);
        adicionarBotao("/", corLaranja, cons, 0, 3 );

        // Linha 02
        adicionarBotao("7", corCinzaClaro, cons, 1, 0);
        adicionarBotao("8", corCinzaClaro, cons, 1, 1);
        adicionarBotao("9", corCinzaClaro, cons, 1, 2);
        adicionarBotao("X", corLaranja, cons, 1, 3);

        // Linha 03
        adicionarBotao("4", corCinzaClaro, cons, 2, 0);
        adicionarBotao("5", corCinzaClaro, cons, 2, 1);
        adicionarBotao("6", corCinzaClaro, cons, 2, 2);
        adicionarBotao("-", corLaranja, cons, 2, 3);

        // Linha 04
        adicionarBotao("1", corCinzaClaro, cons, 3, 0);
        adicionarBotao("2",corCinzaClaro, cons, 3, 1 );
        adicionarBotao("3", corCinzaClaro, cons, 3, 2);
        adicionarBotao("+", corLaranja, cons, 3, 3);

        //Linha 05
        cons.gridwidth = 2;
        adicionarBotao("0", corCinzaClaro, cons, 4, 0);
        cons.gridwidth = 1;
        adicionarBotao(",", corCinzaClaro, cons, 4, 2);
        adicionarBotao("=", corLaranja, cons, 4, 3);
    }

    private void adicionarBotao(String texto, Color cor, GridBagConstraints cons, int y, int x  ){
        cons.gridy = y;
        cons.gridx = x;

        Botao botao = new Botao(texto, cor);

        add(botao, cons);

    }
}
