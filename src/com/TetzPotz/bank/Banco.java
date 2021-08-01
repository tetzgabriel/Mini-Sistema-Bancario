package com.TetzPotz.bank;

import com.TetzPotz.bank.Exceptions.AccountNotFoundException;
import com.TetzPotz.bank.Exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Banco {
    private int numeroAgencias;
    private int balanco;
    private int id;

    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    public Banco(int numeroAgencias, int balanco, int id, ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
        this.numeroAgencias = numeroAgencias;
        this.balanco = balanco;
        this.id = id;
        this.clientes = clientes;
        this.contas = contas;
    }

    public int getNumeroAgencias() {
        return numeroAgencias;
    }

    public void setNumeroAgencias(int numeroAgencias) {
        this.numeroAgencias = numeroAgencias;
    }

    public int getBalanco() {
        return balanco;
    }

    public void setBalanco(int balanco) {
        this.balanco = balanco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public int calculaBalanco() {
        if (this.contas.isEmpty()){
            return 0;
        } else {
            int balancoLocal = 0, i = 0;

            for (i = 0; i < this.contas.size(); i++) {
                balancoLocal += this.contas.get(i).getSaldo(); //this.contas[i] nao funciona por ser ArrayList
            }
            return balancoLocal;
        }
    }

    public void adicionaCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionaConta(Conta conta) {
        this.contas.add(conta);
    }

    public void showClientes() {
//        for (i = 0; i < this.clientes.size(); i++){
//            System.out.println("-----Cliente "+ i+1 + "-----");
//            System.out.println("Nome do cliente: " + this.clientes.get(i).getNome());
//            System.out.println("CPF do cliente: " + this.clientes.get(i).getCpf());
//        }

        this.clientes.forEach(cliente -> { // foreach = funcao do ArrayList
            System.out.println("-----Cliente-----");
            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("CPF do cliente: " + cliente.getCpf());
        });
    }

    public void showContas() {
        this.contas.forEach(conta -> { // foreach = funcao do ArrayList
            System.out.println("-----Conta "+ conta.getId() +"-----");
            System.out.println("Nome do titular da conta: " + conta.getNome());
            System.out.println("CPF do titular da conta: " + conta.getCpf());
        });
    }

    public void saldoCliente() throws UserNotFoundException {
        Scanner leitor =  new Scanner(System.in);
        int cpfLocal;
        AtomicInteger encontrou = new AtomicInteger();
        AtomicInteger saldoLocal = new AtomicInteger();

        System.out.println("CPF do cliente desejado: ");
        cpfLocal = leitor.nextInt();

        this.contas.forEach(conta -> {
            if (cpfLocal == conta.getCpf()) {
                encontrou.set(1);
                saldoLocal.addAndGet(conta.getSaldo());
            }
        });

        if (encontrou.get() == 1) {
            System.out.println("Saldo do cliente: "+ saldoLocal.get()/100);
        } else {
            throw new UserNotFoundException("Usuario nao encontrado");
        }
    }

    public void saldoConta() throws AccountNotFoundException {
        Scanner leitor =  new Scanner(System.in);
        int idLocal;
        AtomicInteger encontrou = new AtomicInteger();
        AtomicInteger saldoLocal = new AtomicInteger();

        System.out.println("CPF do cliente desejado: ");
        idLocal = leitor.nextInt();

        this.contas.forEach(conta -> {
            if (idLocal == conta.getId()) {
                encontrou.set(1);
                saldoLocal.addAndGet(conta.getSaldo());
            }
        });

        if (encontrou.get() == 1) {
            System.out.println("Saldo da conta: "+ saldoLocal.get()/100);
        } else {
            throw new AccountNotFoundException("Conta nao encontrada");
        }
    }

}
