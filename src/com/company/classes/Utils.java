package com.company.classes;

import java.util.List;

public class Utils {
    public static void printFilmes(List<Filme> filmes) {
        System.out.println();
        for (Filme filme : filmes) {
            System.out.println((filmes.indexOf(filme)+1)+" - " + filme);
        }
    }

    public static void printSalas(List<Sala> salas) {
        System.out.println();
        for (Sala sala : salas) {
            System.out.println((salas.indexOf(sala)+1)+" - " + sala);
        }
}

    public static void printSessoes(List<Sessao> sessoes) {
        System.out.println();
        for (Sessao sessao : sessoes) {
            System.out.println((sessoes.indexOf(sessao)+1)+" - " + sessao);
        }
    }
}
