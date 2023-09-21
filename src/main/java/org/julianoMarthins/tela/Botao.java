package org.julianoMarthins.tela;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Botao extends JButton {

    // Classe herda as características da classe JButon, biblioteca para criação de botões na tela.

    //Construtor
    public Botao(String texto, Color cor) {
        setText(texto);
        setFont(new Font("courier", Font.PLAIN, 20));
        setOpaque(true);
        setBackground(cor);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));


    }

}
