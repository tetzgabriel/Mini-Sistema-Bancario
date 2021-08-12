package com.TetzPotz.bank;

import java.util.ArrayList;

/**
 * Classe Cliente possuindo CPF e um nome, alem de um arrayList(do tipo Transferencia) com o extrato referente ao cliente
 */
public class Cliente {
    private int cpf;
    private String nome;

    private ArrayList<Transferencia> extrato;

    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.extrato = new ArrayList<>();
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Transferencia getExtrato(int i) {
        return this.extrato.get(i);
    }

    public void setExtrato(Transferencia transferencia) {
        this.extrato.add(transferencia);
    }

    /**
     * Função para saber quantos elementos o extrato possui pois o mesmo é private, logo precisamos de uma função get para o uso da função .size().
     * Utilizado em estuturas de repetição para percorrer por meio do extrato.
     * @return int tamanho do arrayList extrato.
     */
    public int getTamExtrato() {
        return this.extrato.size();
    }
}
