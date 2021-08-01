package com.TetzPotz.bank;

public class Transferencia {
    private int valor;
    private Conta contaPaga;
    private Conta contaRecebe;

    public Transferencia(int valor, Conta contaPaga, Conta contaRecebe) {
        this.valor = valor;
        this.contaPaga = contaPaga;
        this.contaRecebe = contaRecebe;
    }

    public Transferencia(int valor) {
        this.valor = valor;
        this.contaPaga = new Conta(0, "Governo");
        this.contaRecebe = new Conta( 0, "Usuario");
    }

    @Override
    public String toString() {
        return  "Pagante = " + contaPaga.getNome() +
                "\nConta Pagante = " + contaPaga.getId() +
                "\nValor transferido = " + (valor>0 ? " + " + valor : " - " + valor) +
                "\nRecebente =" + contaRecebe.getNome() +
                "\nConta Recebente =" + contaRecebe.getId() ;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Conta getContaPaga() {
        return contaPaga;
    }

    public void setContaPaga(Conta contaPaga) {
        this.contaPaga = contaPaga;
    }


    public Conta getContaRecebe() {
        return contaRecebe;
    }

    public void setContaRecebe(Conta contaRecebe) {
        this.contaRecebe = contaRecebe;
    }

}
