package com.company.classes;

public class Sessao {
    private Filme filme;
    private Sala sala;
    private String horario;

    public Sessao(Filme filme, Sala sala, String horario) {
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Sessao" + '\n' +
                "filme: " + filme.getNome() + '\n' +
                "sala: " + sala.getNome() + '\n' +
                "Horário: " + horario + '\n';
    }
}