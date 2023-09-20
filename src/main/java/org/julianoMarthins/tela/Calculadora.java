package org.julianoMarthins.tela;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {

    // Está classe é responsável por setar os elementos básicos de tela, ela herda a classe JFrame


    // Construtor
    public Calculadora(){

        organizarLayout();

        /*
         Só a nível de curiosidade, o código 'setUnecorated(true)' irá tirar a barra superior original do tela,
         junto aos ícones de fechar, maximar e minimizar está janela. Utilizada deste método seria para caso o
         programador deseje substituir a barra original do Java Swing por outra criada por ele.
         */


        // Método abaixo define o tamanho da tela, as definições 232x322 é a definida nas calculadoras do MAC
        setSize(232, 324); // Valor alterado para melhor opção de layout

        /*
        O método abaixo encerra a aplicação ao fechar a janela no ícone 'X'. É necessário colocar argumento para este
        método, o argumento 'DISPOSE_ON_CLOSE' encerrará somente a janela em questão, o uso recomendados para
        padronização é o argumento EXIT_ON_CLOSE que encerrará o programa e todas suas funcionalidadedes ao clicar
        com o mouse sobre o ícone 'X'
        */
        // Código não utilizado, somente para exemplo - setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /*
         Método abaixo faz com que a tela abra em um local específico da tela do usuário, o argumento 'null'
         centraliza a tela
         */
        setLocationRelativeTo(null);

        // Método para que a tela seja aberta
        setVisible(true);

    }


    public void organizarLayout(){

        /*
        BorderLayout é um gerenciador de Layout, ele define a tela em 'norte, sul, lest, oeste e centro'. Como nossa
        calculadora possui um display ao norte e um teclado centralizado, o método BorderLayout se torna interessante
        ao nosso programa
         */
        setLayout(new BorderLayout());

        /*
        Abaixo instanciamos um objeto para cada classe entre elas a classe display e teclado, ambas são adicionadas ao
        JFrame pelo método add, que adiciona estes elementos a classe JFrame.

        Dentro do argumento de add, após ser adicionado o display, no caso de exemplo, chamamos o BorderLayout.NORTH,
        que definirá que, o display fica ao norte da tela de nossa aplicação.

        O método 'setPrefereedSize()' passando como argumento 'new Dimension(233, 60)' setará o tamanho do display
        norte para os tamanhos 233, 60, sendo largura e altura respectivamente.
        */
        Display display = new Display();
        display.setPreferredSize(new Dimension(233, 60));
        add(display, BorderLayout.NORTH);
        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER);

    }

}
