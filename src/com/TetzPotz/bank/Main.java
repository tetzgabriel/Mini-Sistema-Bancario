package com.TetzPotz.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor =  new Scanner(System.in);

        //instanciar o banco como objeto chamado agencia
        int opcao = 0, subOpcao = 0;

        // Inicializando todos os clientes
        agencia.adicionaCliente(new Cliente(1,"Pedro Potenza"));
        agencia.adicionaCliente(new Cliente(2,"Gabriel Tetzlaf"));
        agencia.adicionaCliente(new Cliente(3,"Thiago Gottardi"));
        agencia.adicionaCliente(new Cliente(4,"Claudia Soares"));
        agencia.adicionaCliente(new Cliente(5,"Maria Antonieta"));

        //Inicializando todas as contas
        agencia.adicionaConta(new Conta(1,"Pedro Potenza"));
        agencia.adicionaConta(new Conta(2,"Gabriel Tetzlaf"));
        agencia.adicionaConta(new Conta(3,"Thiago Gottardi"));
        agencia.adicionaConta(new Conta(4,"Claudia Soares"));
        agencia.adicionaConta(new Conta(5,"Maria Antonieta"));

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
                    agencia.showClientes();
                    break;
                case 1:

                    break;
                case 2:
                    System.out.println("(1) Saldo de cliente");
                    System.out.println("(2) Saldo de conta");

                    subOpcao = leitor.nextInt();

                    break;
                case 3:
                    System.out.println("(1) Extrato de cliente");
                    System.out.println("(2) Extrato de conta");

                    subOpcao = leitor.nextInt();
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
