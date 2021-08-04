package com.TetzPotz.bank;

import java.util.ArrayList;

public class Cliente {
    private int cpf;
    private String nome;

    private ArrayList<Transferencia> extrato;

    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.extrato = new ArrayList<>();
    }

    public Cliente() {

    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Transferencia getExtrato(int i) {
        return this.extrato.get(i);
    }

    public void setExtrato(Transferencia transferencia) {
        this.extrato.add(transferencia);
    }

    public int getTamExtrato() {
        return this.extrato.size();
    }
}
