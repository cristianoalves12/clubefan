package com.company;

import com.company.classes.Filme;
import com.company.classes.Sala;
import com.company.classes.Sessao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static List<Filme> listFilme = new ArrayList<>();
    static List<Sala> listSala = new ArrayList<>();
    static List<Sessao> listSessao = new ArrayList<>();

    public static void listarFilmes(){
        for(Filme filme : listFilme){
            System.out.println((listFilme.indexOf(filme) + 1) + "-" + filme.getNome());
        }
    }

    public static void cadastrarFilmes(){
        System.out.println("Digite os dados do filme");
        System.out.print("Nome: ");
        String nome = sc.next();
        sc.nextLine();
        System.out.print("Diretor: ");
        String diretor = sc.next();
        sc.nextLine();
        System.out.print("Ano de Lançamento: ");
        int anoLanc = sc.nextInt();
        while (ValidarFilme(listFilme, nome, anoLanc)) {
            System.out.println("O FILME " + nome + " lançado em " + anoLanc +" JÁ ESTÁ CADASTRADO NA LISTA, FAVOR INFORMAR OUTRO: ");
            System.out.print("Nome: ");
            nome = sc.next();
            sc.nextLine();
            System.out.print("Ano de Lançamento: ");
            anoLanc = sc.nextInt();
        }
        sc.nextLine();

        System.out.print("Tipo: ");
        String tipo = sc.next();
        sc.nextLine();
        System.out.print("Sinopse: ");
        String sinopse = sc.nextLine();

        listFilme.add(new Filme(nome, diretor, anoLanc, tipo, sinopse));
    }

    public static void cadastrarSala(){
        System.out.println("Digite os dados da sala");
        System.out.print("Nome: ");
        String nome = sc.next();
        sc.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = sc.nextInt();
        while (ValidarSala(listSala, nome)) {
            System.out.println("A SALA " + nome + " JÁ ESTÁ CADASTRADA NA LISTA, FAVOR INFORMAR OUTRA: ");
            System.out.print("Nome: ");
            nome = sc.next();
            sc.nextLine();
        }

        listSala.add(new Sala(nome, capacidade));
    }

    public static void cadastrarSessao(){
        System.out.println("Digite os dados da sessão");
        listarFilmes();
        System.out.print("Filme: ");
        String nFilme = sc.next();
        sc.nextLine();
        Filme filme = listFilme.stream().filter(x -> x.getNome().equals(nFilme)).findFirst().orElse(null);
        System.out.print("Sala: ");
        System.out.println(listSala);
        String nSala = sc.next();
        sc.nextLine();
        Sala sala = listSala.stream().filter(x -> x.getNome().equals(nSala)).findFirst().orElse(null);

        listSessao.add(new Sessao(filme, sala));
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int opMenuGeral;
        int opCrud;
        int opList;

        do {
            System.out.println("1-Gerenciar filme");
            System.out.println("2-Gerenciar sala");
            System.out.println("3-Gerenciar sessão");
            opMenuGeral = sc.nextInt();

            if (opMenuGeral == 1) {
                do {
                    System.out.println("1-Adcionar filme");
                    System.out.println("2-Deletar um filme");
                    System.out.println("3-Listar filmes");
                    System.out.println("0-Voltar");
                    opCrud = sc.nextInt();
                    if (opCrud == 1) {
                        do {
                            cadastrarFilmes();
                            System.out.println("Deseja adicionar outro filme? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                    if (opCrud == 2) {
                        System.out.println("INFORME O FILME QUE DESEJA REMOVER: ");
                        String filmeRem = sc.next();

                        Filme filme = listFilme.stream().filter(x -> x.getNome().equals(filmeRem)).findFirst().orElse(null);

                        if (filme == null) {
                            System.out.println("FILME NÃO ESTÁ CADASTRADO!");
                        } else {
                            listFilme.remove(filme);
                            System.out.println("Filme deletado");
                        }
                    }

                    if (opCrud == 3) {
                        System.out.println(listFilme);
                    }
                }while (opCrud != 0);

            }

            if (opMenuGeral == 2) {
                do {
                    System.out.println("1-Adcionar sala");
                    System.out.println("2-Deletar uma sala");
                    System.out.println("3-Listar salas");
                    System.out.println("4-Alterar sala");
                    System.out.println("0-Voltar");
                    opCrud = sc.nextInt();
                    if (opCrud == 1) {
                        do {
                            cadastrarSala();
                            System.out.println("Deseja adicionar outra sala? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                    if (opCrud == 2) {
                        do {
                            System.out.println("INFORME O SALA QUE DESEJA REMOVER: ");
                            String salaRem = sc.next();

                            Sala sala = listSala.stream().filter(x -> x.getNome().equals(salaRem)).findFirst().orElse(null);

                            if (sala == null) {
                                System.out.println("SALA NÃO ESTÁ CADASTRADA!");
                            } else {
                                listSala.remove(sala);
                                System.out.println("Sala deletada");
                            }
                            System.out.println("Deseja remover outra sala? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                    if (opCrud == 3) {
                        System.out.println(listSala);
                    }

                    if (opCrud == 4) {
                        do{
                        System.out.println("INFORME A SALA QUE DESEJA ALTERAR: ");
                        String salaAlt = sc.next();

                        Sala sala = listSala.stream().filter(x -> x.getNome().equals(salaAlt)).findFirst().orElse(null);
                            if (sala == null) {
                                System.out.println("SALA NÃO ESTÁ CADASTRADA!");
                            } else {
                                System.out.println("INFORME O NOVO NOME: ");
                                String novoNome = sc.next();
                                sala.setNome(novoNome);
                                System.out.println("INFORME A NOVA CAPACIDADE: ");
                                String novoCapacidade = sc.next();
                                sala.setNome(novoCapacidade);
                                System.out.println("Sala alterada");
                            }

                            System.out.println("Deseja alterar outra sala? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                }while (opCrud != 0);

            }

            if (opMenuGeral == 3) {
                cadastrarSessao();
                System.out.println(listSessao);

            }

        } while (opMenuGeral != 0);
    }
    public static boolean ValidarFilme(List<Filme> listFilme, String nome, int anoLanc) {
        Filme filme = listFilme.stream().filter(x -> x.getNome().equals(nome) && x.getAnoLancamento() == anoLanc).findFirst().orElse(null);
        return filme != null;
    }

    public static boolean ValidarSala(List<Sala> listSala, String nome) {
        Sala sala = listSala.stream().filter(x -> x.getNome().equals(nome)).findFirst().orElse(null);
        return sala != null;
    }
}
