package com.TetzPotz.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor =  new Scanner(System.in);
        int opcao = 0, subOpcao = 0;

        do {
            System.out.println("Escolha um item pelo numero");
            System.out.println("(0) Lista de Clientes");
            System.out.println("(1) Lista de Contas");
            System.out.println("(2) Saldo");
            System.out.println("(3) Extrato");
            System.out.println("(4) Realizar Transferencia");
            System.out.println("(5) Valor Total das Contas");
            System.out.println("(6) Sair");

            opcao = leitor.nextInt();

            switch(opcao) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    opcao = -1;
                    System.out.println("Saindo...");

                    break;
                default:
                    System.out.println("Escolha uma opcao valida");
                    break;
            }
        } while (opcao != -1);
    }
}
