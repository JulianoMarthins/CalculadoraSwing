package org.julianoMarthins.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Memoria {

    private enum TipoComando {
        ZERAR, SINAL, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, PORCENTO, VIRGULA
    }

    private static final Memoria instancia = new Memoria();
    private final List<Observador> observadoresList = new ArrayList<>();

    private TipoComando ultimaOperacao = null;
    private Boolean substituir = false;
    private String textoAtual = "";
    private String textoBuffer = "";

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

        if (tipo == null) {
            return;
        } else if (tipo == TipoComando.ZERAR) {
            textoAtual = "";
            textoBuffer = "";
            substituir = false;
            ultimaOperacao = null;
        } else if (tipo == TipoComando.SINAL && textoAtual.contains("-")) {
            textoAtual = textoAtual.substring(1);
        } else if (tipo == TipoComando.SINAL && !textoAtual.contains("-")) {
            textoAtual = "-" + textoAtual;
        } else if (tipo == TipoComando.NUMERO || tipo == TipoComando.VIRGULA) {
            textoAtual = substituir ? texto : textoAtual + texto;
            substituir = false;
        } else {

            substituir = true;
            textoAtual = obterResultadoOperacao();
            textoBuffer = textoAtual;
            ultimaOperacao = tipo;

        }

        observadoresList.forEach(x -> x.valorAlterado(getTextoAtual()));

    }

    private String obterResultadoOperacao() {
        if (ultimaOperacao == null || ultimaOperacao == TipoComando.IGUAL) {
            return textoAtual;
        }

        double numBuffer = Double.parseDouble(textoBuffer.replace(", ", "."));
        double numAtual = Double.parseDouble(textoAtual.replace(",", "."));
        double resultado = 0.0;

        if (ultimaOperacao == TipoComando.SOMA) {
            resultado = numBuffer + numAtual;
        } else if (ultimaOperacao == TipoComando.SUB) {
            resultado = numBuffer - numAtual;
        } else if (ultimaOperacao == TipoComando.DIV) {
            resultado = numBuffer / numAtual;
        } else if (ultimaOperacao == TipoComando.MULT) {
            resultado = numBuffer * numAtual;
        } else if (ultimaOperacao == TipoComando.PORCENTO) {
            if (ultimaOperacao == TipoComando.SOMA) {
                resultado = numAtual + numAtual * 100 / numBuffer;
            } else if (ultimaOperacao == TipoComando.SUB) {
                resultado = numAtual - numAtual * 100 / numBuffer;
            }
        }

        String resultadoConvertido = Double.toString(resultado).replace(".", ",");
        boolean inteiro = resultadoConvertido.endsWith(",0");
        return inteiro ? resultadoConvertido.replace(",0", "") : resultadoConvertido;

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
            if ("±".equals(texto)) {
                return TipoComando.SINAL;
            }

            if (",".equals(texto) && !textoAtual.contains(",")) {
                return TipoComando.VIRGULA;
            }
        }

        return null;
    }


}
