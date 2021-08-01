package com.TetzPotz.bank;

import java.util.ArrayList;

public class Conta extends Cliente{
    private int numeroContas;
    private int id;
    private int saldo;
    private ArrayList<Integer> extrato;

    public Conta(int numeroContas, int id, int saldo, ArrayList<Integer> extrato) {
        super();
        this.numeroContas = numeroContas;
        this.id = id;
        this.saldo = saldo;
        this.extrato = extrato;
        this.extrato.add(10000);
    }

    public int getNumeroContas() {
        return numeroContas;
    }

    public void setNumeroContas(int numeroContas) {
        this.numeroContas = numeroContas;
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

    public int[] getExtrato() {
        return extrato;
    }

    public void setExtrato(int valor) {
        this.extrato.add(valor);
    }

    public int getTamExtrato() {
        return this.extrato.size();
    }
}
