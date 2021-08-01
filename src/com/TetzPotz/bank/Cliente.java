package com.TetzPotz.bank;

public class Cliente {
    private int cpf;
    private String nome;

    protected int[] Extrato;

    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
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

    public int getExtrato(int i) {
        return this.Extrato[i];
    }

    public void setExtrato(int[] extrato) {
        Extrato = extrato;
    }

    public int getTamExtrato() {
        return this.Extrato.length;
    }
}
