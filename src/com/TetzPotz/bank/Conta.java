package com.TetzPotz.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Conta extends Cliente{
    private int numeroContas;
    private int id;
    private int saldo;
    private ArrayList<Integer> extrato;

    public Conta(int cpf, String nome ) {

        this.saldo = 10000;
        this.extrato = new ArrayList<Integer>();
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

    public ArrayList<Integer> getExtrato() {
        return extrato;
    }

    public void setExtrato(int valor) {
        this.extrato.add(valor);
    }

    public int getTamExtrato() {
        return this.extrato.size();
    }
}
