package org.julianoMarthins.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Memoria {

    private enum TipoComando {
        ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA
    }

    private static final Memoria instancia = new Memoria();
    private final List<Observador> observadoresList = new ArrayList<>();

    private String textoAtual = "";

    /*
    A criação de um método privado protege o programa para que ele seja criado somente um objeto desta classe, este
    deve ser instanciado pelo método getInstancia que retorna o atributo, criado como privado, estático e sendo este
    um valor final, denominado instancia.
     */
    private Memoria() {

    }

    public static Memoria getInstancia() {
        return instancia;
    }

    public void addObservador(Observador observador) {
        observadoresList.add(observador);
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void processarComando(String texto) {
        TipoComando tipo = detectarTipoComando(texto);


        if ("AC".equals(texto)) {
            this.textoAtual = "";
            System.out.println(texto);
            observadoresList.forEach(x -> x.valorAlterado(getTextoAtual()));
        } else {
            this.textoAtual += texto;
            System.out.println(texto);
            observadoresList.forEach(x -> x.valorAlterado(textoAtual));
        }
    }


    private TipoComando detectarTipoComando(String texto) {
        if (textoAtual.isEmpty() && texto == "0") {
            return null;
        }

        try {
            Integer.parseInt(texto);
            return TipoComando.NUMERO;
        } catch (NumberFormatException e) {
            // Quando texto não for numérico, catch é acionado
            if ("AC".equals(texto)) {
                return TipoComando.ZERAR;
            }
            if ("/".equals(texto)) {
                return TipoComando.DIV;
            }
            if ("x".equals(texto)) {
                return TipoComando.MULT;
            }
            if ("-".equals(texto)) {
                return TipoComando.SUB;
            }
            if ("+".equals(texto)) {
                return TipoComando.SOMA;
            }
            if ("=".equals(texto)) {
                return TipoComando.IGUAL;
            }
            if (",".equals(texto)) {
                return TipoComando.VIRGULA;
            }
        }

        return null;
    }


}
