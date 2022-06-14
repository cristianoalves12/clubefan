package com.company.classes;

import java.util.ArrayList;
import java.util.List;
// = {"16:00", "17:00", "18:00", "19:30", "20:00", "20:00", "22:00", "24:00"};
public class Filme {

    private String nome;
    private String nomeOriginal;
    private List<String> horario = new ArrayList<>();
    private List<String> sala = new ArrayList<>();
    private String diretor;
    private int anoLancamento;

    public Filme(String nome, String nomeOriginal, List<String> horario, List<String> sala, String diretor, int anoLancamento) {
        this.nome = nome;
        this.nomeOriginal = nomeOriginal;
        this.horario = horario;
        this.sala = sala;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public List<String> getHorario() {
        return horario;
    }

    public void setHorario(List<String> horario) {
        this.horario = horario;
    }

    public List<String> getSala() {
        return sala;
    }

    public void setSala(List<String> sala) {
        this.sala = sala;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
