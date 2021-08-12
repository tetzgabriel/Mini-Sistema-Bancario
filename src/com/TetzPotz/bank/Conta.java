package com.TetzPotz.bank;

import java.util.ArrayList;

/**
 * Classe Conta com id preenchido de forma automatica (se auto-incrementando) a partir do valor 400, saldo da conta.
 * classe herda cliente logo possui CPF e nome tambem, assim como um extrato referente.
 */
public class Conta extends Cliente{
    private static int numeroContas = 400; //variavel estática para funcionar o auto incremento
    private int id;
    private int saldo;

    /**
     * Constructor de conta
     * @param cpf recebe cpf e passa para o construtor do Cliente
     * @param nome recebe nome e passa para o construtor do Cliente
     * Adiciona 100000 ao saldo
     * Atribui o id para a conta e incrementa o numeroContas (variavel estática)
     */
    public Conta(int cpf, String nome ) {
        super(cpf, nome);

        this.saldo = 100000;
        this.id = numeroContas;

        numeroContas++;
    }

    public int getId() {
        return id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
