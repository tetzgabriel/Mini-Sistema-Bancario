package com.TetzPotz.bank;

import java.util.ArrayList;

public class Conta extends Cliente{
    private static int numeroContas = 400;
    private int id;
    private int saldo;

    public Conta(int cpf, String nome ) {
        super(cpf, nome);

        this.saldo = 100000;
        this.id = numeroContas;

        numeroContas++;
    }

    public int getNumeroContas() {
        return numeroContas;
    }

    public void setNumeroContas(int numeroContas) {
        Conta.numeroContas = numeroContas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
