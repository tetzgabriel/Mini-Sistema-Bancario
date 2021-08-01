package com.TetzPotz.bank;

import java.util.ArrayList;

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
}
