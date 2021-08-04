package com.TetzPotz.bank;

public class Transferencia {
    private int valor;
    private final int tipo;
    private Conta contaPaga;
    private Conta contaRecebe;
    private Cliente clientePaga;
    private Cliente clienteRecebe;

    public Transferencia(int valor, Conta contaPaga, Conta contaRecebe) {
        this.valor = valor;
        this.contaPaga = contaPaga;
        this.contaRecebe = contaRecebe;
        this.tipo = 1;
    }

    public Transferencia(int valor, Cliente clientePaga, Cliente clienteRecebe) {
        this.valor = valor;
        this.clientePaga = clientePaga;
        this.clienteRecebe = clienteRecebe;
        this.tipo = 2;
    }

    public Transferencia(int valor) {
        this.valor = valor;
        this.tipo = 1;
        this.contaPaga = new Conta(0, "Governo");
        this.contaRecebe = new Conta( 0, "Usuario");
    }

    @Override
    public String toString() {
        if(this.tipo == 1){
            return  "Pagante = " + this.contaPaga.getNome() +
                    "\nConta Pagante = " + this.contaPaga.getId() +
                    "\nValor transferido = " + this.valor +
                    "\nRecebente = " + this.contaRecebe.getNome() +
                    "\nConta Recebente = " + this.contaRecebe.getId() ;
        } else {
            return  "Pagante = " + this.clientePaga.getNome() +
                    "\nCPF Pagante = " + this.clientePaga.getCpf() +
                    "\nValor transferido = " + this.valor+
                    "\nRecebente = " + this.clienteRecebe.getNome() +
                    "\nCPF Recebente = " + this.clienteRecebe.getCpf() ;
        }
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
