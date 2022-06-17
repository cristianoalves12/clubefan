package com.company.classes;

import java.util.ArrayList;
import java.util.List;
// = {"16:00", "17:00", "18:00", "19:30", "20:00", "20:00", "22:00", "24:00"};
public class Filme {

    private String nome;
    private String nomeOriginal;
    private String diretor;
    private int anoLancamento;
    private String tipo;
    private String sinopse;

    public Filme(String nome, String diretor, int anoLancamento, String tipo, String sinopse) {
        this.nome = nome;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.tipo = tipo;
        this.sinopse = sinopse;
    }

    public Filme(String nome, String nomeOriginal, String diretor, int anoLancamento, String tipo, String sinopse) {
        this.nome = nome;
        this.nomeOriginal = nomeOriginal;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.tipo = tipo;
        this.sinopse = sinopse;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return nome + '\n' +
               diretor + '\n' +
               anoLancamento  + '\n' +
               tipo + '\n' +
               sinopse + '\n' +
                '\n';
    }
}
