package com.company.classes;

public class Sala{
    private String nome;
    private int capacidade;

    private int horario;

    public Sala(String nome, int capacidade, int horario) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Sala: " + nome + '\n' +
                "Capacidade: " + capacidade + '\n' +
                "Horario: " + horario + ":00" + '\n' + '\n';
    }
}