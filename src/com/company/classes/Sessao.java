package com.company.classes;

import java.util.Date;

public class Sessao {
    private Filme filme;
    private Sala sala;


    public Sessao(Filme filme, Sala sala) {
        this.filme = filme;
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Sessao 1" + '\n' +
                "filme: " + filme.getNome() + '\n' +
                "sala: " + sala.getNome() + '\n';
    }
}