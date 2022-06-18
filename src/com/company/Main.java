package com.company;

import com.company.classes.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static List<Filme> listFilme = new ArrayList<>();

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
                System.out.println("1-Adcionar um filme");
                System.out.println("2-Deletar um filme");
                System.out.println("3-Listar filmes");
                System.out.println("0-Voltar");
                opCrud = sc.nextInt();
                do {
                    if (opCrud == 1) {
                        do {
                            cadastrarFilmes();
                            System.out.println("Deseja adicionar outro filme? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                    if (opCrud == 2) {
                        System.out.println("INFORME O FILME QUE DESEJA REMOVER: ");
                        int filmeRem = sc.nextInt();
                        Filme filme = listFilme.stream().filter(x -> x.getNome().equals(filmeRem)).findFirst().orElse(null);

                        if (filme == null) {
                            System.out.println("FUNCIONÁRIO NÃO EXISTE NA LISTAGEM!");
                        } else {
                            //listFilme.remove(listFilme.indexOf(filme)); remoção com erro
                        }
                    }

                    if (opCrud == 3) {
                        System.out.println(listFilme);
                    }

                    System.out.println("1-Adcionar um filme");
                    System.out.println("2-Deletar um filme");
                    System.out.println("3-Listar filmes");
                    System.out.println("0-Voltar");
                    opCrud = sc.nextInt();
                }while (opCrud != 0);

            }

            if (opMenuGeral == 2) {
                listarFilmes();
            }

        } while (opMenuGeral != 0);
    }
    public static boolean ValidarFilme(List<Filme> listFilme, String nome, int anoLanc) {
        Filme filme = listFilme.stream().filter(x -> x.getNome().equals(nome) && x.getAnoLancamento() == anoLanc).findFirst().orElse(null);
        return filme != null;

    }
}
