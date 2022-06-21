package com.company;

import com.company.classes.Filme;
import com.company.classes.Sala;
import com.company.classes.Sessao;
import com.company.classes.Utils;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static List<Filme> listFilme = new ArrayList<>();
    static List<Sala> listSala = new ArrayList<>();
    static List<Sessao> listSessao = new ArrayList<>();
    static List<String> listHorarios = Arrays.asList("16:00", "17:00", "18:00", "19:30", "20:00", "22:00", "24:00");

    public static void listarFilmes(){
        System.out.println("Filmes cadastrados:");
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
        sc.nextLine();

        while (ValidarSala(listSala, nome)) {
            System.out.println("A SALA " + nome + " JÁ ESTÁ CADASTRADA NA LISTA, FAVOR INFORMAR OUTRO NOME: ");
            System.out.print("Nome: ");
            nome = sc.next();
            sc.nextLine();
        }

        listSala.add(new Sala(nome, capacidade));
    }

    public static void cadastrarSessao(){
        System.out.println("Digite os dados da sessão");
        listarFilmes();
        System.out.print("Nome do filme: ");
        String nFilme = sc.next();
        sc.nextLine();
        Filme filme = listFilme.stream().filter(x -> x.getNome().equals(nFilme)).findFirst().orElse(null);
        Utils.printSalas(listSala);
        System.out.print("Sala: ");
        String nSala = sc.next();
        sc.nextLine();
        Sala sala = listSala.stream().filter(x -> x.getNome().equals(nSala)).findFirst().orElse(null);
        List<String> horariosDisponiveis = getHorariosLivres(sala);
        if (horariosDisponiveis.isEmpty()){
            System.out.println("A sala" + sala.getNome() + "não possui horários disponiveis");
            return ;
        }
        for (String horario : horariosDisponiveis){
            System.out.println((horariosDisponiveis.indexOf(horario) + 1) + "-" + horario);
        }
        System.out.print("O número do horário: ");
        int nHorario = sc.nextInt();
        sc.nextLine();

        listSessao.add(new Sessao(filme, sala, horariosDisponiveis.get(nHorario - 1)));
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
                    System.out.println("4-Alterar filme");
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
                            System.out.println("ESTE FILME NÃO ESTÁ CADASTRADO, FAVOR INFORMAR OUTRO!");
                        } else {
                            listFilme.remove(filme);
                            System.out.printf("FILME: '%s' REMOVIDO COM SUCESSO! %n", filmeRem);
                        }
                    }

                    if (opCrud == 3) {
                       Utils.printFilmes(listFilme);
                    }
                    if (opCrud == 4) {
                        do{
                            System.out.println("INFORME O NOME DO FILME QUE DESEJA ALTERAR: ");
                            String filmeAlt = sc.next();

                            Filme filme = listFilme.stream().filter(x -> x.getNome().equals(filmeAlt)).findFirst().orElse(null);

                            if (filme == null) {
                                System.out.println("ESTE FILME NÃO ESTÁ CADASTRADO, FAVOR INFORMAR OUTRO!");
                            } else {
                                System.out.println("INFORME O NOVO NOME: ");
                                String novoNome = sc.next();
                                filme.setNome(novoNome);
                                System.out.println("INFORME O NOVO DIRETOR: ");
                                String novoDiretor = sc.next();
                                filme.setDiretor(novoDiretor);
                                System.out.println("INFORME O NOVO ANO DE LANÇAMENTO: ");
                                int novoAnoLancamento = sc.nextInt();
                                filme.setAnoLancamento(novoAnoLancamento);
                                System.out.println("INFORME O NOVO TIPO: ");
                                String novoTipo = sc.next();
                                filme.setTipo(novoTipo);
                                System.out.println("INFORME A NOVA SINOPSE: ");
                                String novaSinopse = sc.next();
                                filme.setSinopse(novaSinopse);
                                System.out.printf("FILME: '%s' ALTERADO COM SUCESSO! %n", filmeAlt);
                            }

                            System.out.println("Deseja alterar outro filme? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
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
                            System.out.println("INFORME A SALA QUE DESEJA REMOVER: ");
                            String salaRem = sc.next();

                            Sala sala = listSala.stream().filter(x -> x.getNome().equals(salaRem)).findFirst().orElse(null);

                            if (sala == null) {
                                System.out.println("ESTA SALA NÃO ESTÁ CADASTRADA, FAVOR INFORMAR OUTRA!");
                            } else {
                                listSala.remove(sala);
                                System.out.printf("SALA: '%s' REMOVIDA COM SUCESSO! %n", salaRem);
                            }
                            System.out.println("Deseja remover outra sala? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                    if (opCrud == 3) {
                       Utils.printSalas(listSala);
                    }

                    if (opCrud == 4) {
                        do{
                        System.out.println("INFORME O NOME DA SALA QUE DESEJA ALTERAR: ");
                        String salaAlt = sc.next();

                        Sala sala = listSala.stream().filter(x -> x.getNome().equals(salaAlt)).findFirst().orElse(null);
                            if (sala == null) {
                                System.out.println("ESTA SALA NÃO ESTÁ CADASTRADA, FAVOR INFORMAR OUTRA!");
                            } else {
                                System.out.println("INFORME O NOVO NOME: ");
                                String novoNome = sc.next();
                                sala.setNome(novoNome);
                                System.out.println("INFORME A NOVA CAPACIDADE: ");
                                int novoCapacidade = sc.nextInt();
                                sala.setCapacidade(novoCapacidade);
                                System.out.printf("SALA: '%s' ALTERADA COM SUCESSO! %n", salaAlt);
                            }

                            System.out.println("Deseja alterar outra sala? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                }while (opCrud != 0);

            }

            if (opMenuGeral == 3) {
                do {
                    System.out.println("1-Adcionar sessão");
                    System.out.println("2-Listar salas");
                    System.out.println("0-Voltar");
                    opCrud = sc.nextInt();
                    if (opCrud == 1) {
                        do {
                            cadastrarSessao();
                            System.out.println("Deseja adicionar outra sessão? [1]Sim [2]Não");
                            opList = sc.nextInt();
                        } while (opList == 1);
                    }

                    if (opCrud == 2) {
                        Utils.printSessoes(listSessao);
                    }

                }while (opCrud != 0);

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

    public static List<String> getHorariosLivres(Sala sala) {
        List<Sessao> listSessoes = new ArrayList<>();
        for (Sessao sessao: listSessao) {
            if (sessao.getSala().getNome() == sala.getNome()) {
                listSessoes.add(sessao);
            }
        }

        if(listSessoes.isEmpty()) return listHorarios;


        List<String> horariosLivres = new ArrayList<>();


        for (Sessao sessao : listSessoes) {
            for (String horario : listHorarios) {
                if (horario.equals("Indisponivel")) {
                    break;
                }
                if (sessao.getHorario().equals(horario)) {
                    horariosLivres.add("Indisponivel");
                } else {
                    horariosLivres.add(horario);
                }
            }
        }
        return horariosLivres;
    }

}