package org.julianoMarthins.modelo;

@FunctionalInterface
public interface Observador {

    public void valorAlterado(String novoValor);
}
