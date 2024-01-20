package projetos.java.ti.blackjack;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void cabecalho() {
        System.out.println("--------------------------------------");
        System.out.println("------- * B L A C K  J A C K * -------");
        System.out.println("--------------------------------------");
        System.out.println();
    }

    public static void main(String[] args) {
        var usuario = new Usuario();
        var dados = new Scanner(System.in);

        String continuar;
        String resposta1 = "s";
        double valorNovo = 0;
        double valorFinal = 0;
        double valorArrecadado = 0;
        int jogadas = 0;

        cabecalho();
        System.out.println("Bem vindo jogador!");
        System.out.println("Meu nome é Tigrinho e serei seu Croupler!");
        System.out.println("Me diga qual o seu nome?");
        usuario.setNome(dados.nextLine());
        System.out.println();
        System.out.println("Prazer em conhecer " + usuario.getNome() + "!");
        System.out.println("A regra é simples quem completar 21 vence!");
        System.out.println("Você irá começar com R$ " + usuario.getDinheiro() + "!");
        System.out.println("Irei sempre apostar a mesma quantia!");
        System.out.println();
        System.out.println("Podemos começar o jogo?");
        System.out.println("Aperte qualquer tecla + ENTER para continuar!");
        continuar = dados.nextLine();

        for (int i = 0; i <= 50; i++) {
            System.out.println();
        }

        valorNovo = usuario.getDinheiro();
        do {
            valorNovo = valorNovo;
            cabecalho();
            System.out.println("Você gostaria de apostar quanto?");
            usuario.setAposta(dados.nextDouble());
            System.out.println();
            if (usuario.getAposta() > valorNovo) {
                do {
                    System.out.println("Saldo insulficiente!");
                    System.out.println("Você possui R$ "+ valorNovo + "!");
                    System.out.println("--------------------------------------");
                    System.out.println("Você gostaria de apostar quanto?");
                    usuario.setAposta(dados.nextDouble());
                    System.out.println();
                } while (usuario.getAposta() > valorNovo);
            }
            int numeroPlayerTotal = 0;
            int numeroCPUTotal = 0;
            String resposta;
            System.out.println("Sua primeiras cartas foram: ");
            for (int i = 1; i <= 2; i++) {

                int numeroPlayer = new Random().nextInt(11) + 1;
                System.out.println("Carta Nº: " + numeroPlayer);
                numeroPlayerTotal = numeroPlayerTotal + numeroPlayer;
            }
            System.out.println("Totalizando: " + numeroPlayerTotal);
            System.out.println("Deseja continuar? [s] - SIM / [n] - NÃO");
            resposta = dados.next();
            if (resposta.equals("s")) {
                int numeroPlayer = new Random().nextInt(11) + 1;
                System.out.println("Carta Nº: " + numeroPlayer);
                numeroPlayerTotal = numeroPlayerTotal + numeroPlayer;
                System.out.println("Totalizando: " + numeroPlayerTotal);
            } else {
                System.out.println("Sua pontuação total foi: " + numeroPlayerTotal);
            }
            if (numeroPlayerTotal > 21) {
                System.out.println("Infelizmente você estourou o valor máximo");

            } else if (numeroPlayerTotal == 21) {
                System.out.println("Parabéns! Atingiu o BLACK JACK! ");

            }
            System.out.println("Aperte qualquer tecla + ENTER para continuar!");
            continuar = dados.next();

            for (int i = 0; i <= 50; i++) {
                System.out.println();
            }
            cabecalho();
            System.out.println("Agora é a vez da casa!");
            for (int i = 1; i <= 2; i++) {
                int numeroCPU = new Random().nextInt(11) + 1;
                System.out.println("Carta Nº: " + numeroCPU);
                numeroCPUTotal = numeroCPUTotal + numeroCPU;
            }
            if (numeroCPUTotal <= numeroPlayerTotal) {
                if (numeroCPUTotal < 21) {
                    int numeroCPU = new Random().nextInt(11) + 1;
                    System.out.println("Carta Nº: " + numeroCPU);
                    numeroCPUTotal = numeroCPUTotal + numeroCPU;
                    System.out.println("Totalizando: " + numeroCPUTotal);
                }
            } else {
                System.out.println("Totalizando: " + numeroCPUTotal);
            }
            if (numeroCPUTotal == 21) {
                System.out.println("Casa atingiu BLACKJACK!");
            }
            System.out.println("Aperte qualquer tecla + ENTER para continuar!");
            continuar = dados.next();
            for (int i = 0; i <= 50; i++) {
                System.out.println();
            }
            cabecalho();
            System.out.println("Casa ----- {" + numeroCPUTotal + "} X  {" + numeroPlayerTotal + "} ----- " + usuario.getNome());

            if (numeroPlayerTotal > numeroCPUTotal) {
                if (numeroPlayerTotal > 21) {
                    System.out.println("Infelizmente acaba de perder o valor de R$ " + usuario.getAposta() + " em aposta!");
                    valorNovo = valorNovo - usuario.getAposta();
                } else {
                    System.out.println("Você acaba de ganhar o valor de R$ " + usuario.getAposta() + " em aposta!");
                    valorNovo = valorNovo + usuario.getAposta();
                }
            } else if (numeroPlayerTotal < numeroCPUTotal) {
                if (numeroCPUTotal > 21) {
                    System.out.println("Você acaba de ganhar o valor de R$ " + usuario.getAposta() + " em aposta!");
                    valorNovo = valorNovo + usuario.getAposta();
                } else {
                    System.out.println("Infelizmente acaba de perder o valor de R$ " + usuario.getAposta() + " em aposta!");
                    valorNovo = valorNovo - usuario.getAposta();
                }
            } else if (numeroPlayerTotal == numeroCPUTotal) {
                System.out.println("Houve um empate!");
            }
            System.out.println();
            System.out.println("Valor atual R$ " + valorNovo);
            if (valorNovo == 0) {
                resposta1 = "n";
                System.out.println("Aperte qualquer tecla + ENTER para continuar!");
                continuar = dados.next();
            } else {
                System.out.println("Deseja continuar as apostas? [s] - SIM / [n] - NÃO");
                resposta1 = dados.next();
            }
            for (int i = 0; i <= 50; i++) {
                System.out.println();
            }
            jogadas ++;
        } while (!resposta1.equals("n"));
        if (valorNovo == 0) {
            cabecalho();
            System.out.println("Você perdeu TODO o dinheiro para casa!");
            System.out.println("Jogadas Realizadas: "+ jogadas);
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("------  F I M  D O  J O G O  ! -------");
            System.out.println("--------------------------------------");
        } else {
            valorArrecadado = valorNovo - usuario.getDinheiro();
            valorFinal  = valorArrecadado + usuario.getDinheiro();
            if (valorArrecadado <= 0) {
                cabecalho();
                System.out.println("Você teve prejuizo de R$ " + valorArrecadado);
                System.out.println("Valor total: R$ "+ valorFinal);
            } else {
                cabecalho();
                System.out.println("Você teve lucro de R$ " + valorArrecadado);
                System.out.println("Valor total: R$ "+ valorFinal);
            }
            System.out.println("Jogadas Realizadas: "+ jogadas);
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("------  F I M  D O  J O G O  ! -------");
            System.out.println("--------------------------------------");
        }
    }
}