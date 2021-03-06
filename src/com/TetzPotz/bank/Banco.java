package com.TetzPotz.bank;

import com.TetzPotz.bank.Exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Classe Banco
 * Todas as operações do menu são efetuadas por meio dos métodos da classe
 * Banco possui um id proprio que se autoincrementa assim como em Contas
 */
public class Banco {
    private static int numeroAgencias = 200; //apenas generalização para o caso de existir mais de uma agência
    private int balanco;

    private final ArrayList<Cliente> clientes;
    private final ArrayList<Conta> contas;

    public Banco() {
        this.balanco = 0;
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();

        Banco.numeroAgencias++;
    }

    /**
     * Calcula a soma do saldo de todas as contas do sistema para garantir que o balanço do banco continua correto
     * @return valor total que o banco possui (numero de contas * 100000)
     */
    public int calculaBalanco() {
        if (this.contas.isEmpty()){
            return 0;
        } else {
            int balancoLocal = 0, i;

            for (i = 0; i < this.contas.size(); i++) {
                balancoLocal += this.contas.get(i).getSaldo(); //this.contas[i] nao funciona por ser ArrayList
            }
            this.balanco = balancoLocal;
            return balancoLocal;
        }
    }

    /**
     * Adiciona um cliente no arrayList do banco/agência.
     * @param cliente cliente a ser adicionado no sistema.
     */
    public void adicionaCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    /**
     * Adiciona uma conta no arryList do banco/agência.
     * @param conta conta a ser adicionada no sistema.
     */
    public void adicionaConta(Conta conta) {
        this.contas.add(conta);
    }

    /**
     * Imprime todos os clientes do arrayList de clientes do banco.
     */
    public void showClientes() {

        this.clientes.forEach(cliente -> { // foreach = funcao do ArrayList
            System.out.println("\n-----Cliente-----");
            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("CPF do cliente: " + cliente.getCpf());
        });
    }

    /**
     * Imprime todas as contas do arrayList de contas do banco
     */
    public void showContas() {
        this.contas.forEach(conta -> { // foreach = funcao do ArrayList
            System.out.println("\n-----Conta "+ conta.getId() +"-----");
            System.out.println("Nome do titular da conta: " + conta.getNome());
            System.out.println("CPF do titular da conta: " + conta.getCpf());
        });
    }

    /**
     * Verifica o saldo de um cliente informado pelo usuario
     * @throws UserNotFoundException Caso o usuario não seja encontrado (CPF inexistente)
     */
    public void saldoCliente() throws UserNotFoundException {
        Scanner leitor =  new Scanner(System.in);
        int cpfLocal;
        AtomicInteger encontrou = new AtomicInteger();
        AtomicInteger saldoLocal = new AtomicInteger();

        System.out.println("CPF do cliente desejado: ");
        cpfLocal = leitor.nextInt();

        this.contas.forEach(conta -> {
            if (cpfLocal == conta.getCpf()) {
                encontrou.set(1);
                saldoLocal.addAndGet(conta.getSaldo());
            }
        });

        if (encontrou.get() == 1) {
            System.out.println("Saldo do cliente: "+ String.format("%.2f",(float)saldoLocal.get()/100));
        } else {
            throw new UserNotFoundException("Usuario nao encontrado");
        }
    }

    /**
     * Verifica o saldo de uma conta informada pelo usuario
     * @throws AccountNotFoundException Caso a conta não seja encontrada (idConta inexistente)
     */
    public void saldoConta() throws AccountNotFoundException {
        Scanner leitor =  new Scanner(System.in);
        int idLocal;
        AtomicInteger encontrou = new AtomicInteger();
        AtomicInteger saldoLocal = new AtomicInteger();

        System.out.println("Id da conta desejada: ");
        idLocal = leitor.nextInt();

        this.contas.forEach(conta -> {
            if (idLocal == conta.getId()) {
                encontrou.set(1);
                saldoLocal.addAndGet(conta.getSaldo());
            }
        });

        if (encontrou.get() == 1) {
            System.out.println("Saldo da conta: "+ String.format("%.2f",(float)saldoLocal.get()/100));
        } else {
            throw new AccountNotFoundException("Conta nao encontrada");
        }
    }

    /**
     * Imprime o extrato do cliente com as seguintes informações:
     *  - Pagante: Nome do usuario que transferiu o dinheiro;
     *  - CPF Pagante: CPF do usuario que transferiu o dinheiro;
     *  - Valor transferido: valor transferido (imprime com a conversão de int para float)
     *  - Recebente: Nome do usuario que recebeu a transferencia;
     *  - CPF Recebente: CPF do usuario que recebeu a transferencia;
     * @throws UserNotFoundException Caso não seja encontrado o usuario informado
     */
    public void showExtratoCliente() throws UserNotFoundException {
        Scanner leitor =  new Scanner(System.in);
        int cpfLocal;
        AtomicInteger encontrou = new AtomicInteger();

        System.out.println("CPF do cliente: ");
        cpfLocal = leitor.nextInt();

        this.clientes.forEach(cliente -> {
            if (cpfLocal == cliente.getCpf()) {
                encontrou.set(1);
                for(int i = 0; i < cliente.getTamExtrato(); i++){
                    System.out.println(cliente.getExtrato(i).toString());
                }
            }
        });

        if (encontrou.get() != 1) {
            throw new UserNotFoundException("Usuario nao encontrado");
        }
    }

    /**
     * Imprime o extrato do cliente com as seguintes informações:
     *  - Pagante: Nome do usuario que transferiu o dinheiro;
     *  - Conta Pagante: Numero da conta que transferiu o dinheiro;
     *  - Valor transferido: valor transferido (imprime com a conversão de int para float)
     *  - Recebente: Nome do usuario que recebeu a transferencia;
     *  - Conta Recebente: Numero da conta que recebeu a transferencia;
     * @throws AccountNotFoundException Caso não seja encontrado a conta informada
     */
    public void showExtratoConta() throws AccountNotFoundException {
        Scanner leitor =  new Scanner(System.in);
        int idLocal;
        AtomicInteger encontrou = new AtomicInteger();

        System.out.println("Id da conta: ");
        idLocal = leitor.nextInt();

        this.contas.forEach(conta -> {
            if (idLocal == conta.getId()) {
                encontrou.set(1);
                for(int i = 0; i < conta.getTamExtrato(); i++){
                    System.out.println(conta.getExtrato(i).toString());
                }
            }
        });

        if (encontrou.get() != 1) {
            throw new AccountNotFoundException("Conta nao encontrada");
        }
    }

    /**
     *  Efetua a transferencia entre duas contas verificando a existencia das contas, a quantidade de saldo da conta que envia, verifica o balanço geral do banco
     *  e trata erros de input
     *
     * @throws UserNotFoundException Caso não seja encontrado a conta informada (tanto para o Pagante quanto para o Recebente)
     * @throws WrongBalanceExpetion Caso o balanço do banco seja afetado de alguma forma
     */
    public void transferencia() throws UserNotFoundException, WrongBalanceExpetion {
        Scanner leitor =  new Scanner(System.in);

        int idpaga;
        int valorpago;
        int idrecebe;
        AtomicInteger encontroupaga = new AtomicInteger();
        AtomicInteger encontrourecebe = new AtomicInteger();
        int balancoInicial;
        int balancoFinal;
        float valorInformado;
        String valorInformadoString;

        balancoInicial = this.calculaBalanco();

        System.out.println("Id da conta que envia: ");
        idpaga = leitor.nextInt();

        System.out.println("Id da conta que recebe: ");
        idrecebe = leitor.nextInt();

        this.contas.forEach(conta -> {
            if(idpaga == conta.getId()){
                encontroupaga.set(1);
            }
            if(idrecebe == conta.getId()){
                encontrourecebe.set(1);
            }
        });

        if(encontroupaga.get() != 1){
            throw new UserNotFoundException("Usuario nao encontrado");
        }

        if(encontrourecebe.get() != 1){
            throw new UserNotFoundException("Usuario nao encontrado");
        }

        System.out.println("Valor que deseja transferir: ");
        valorInformadoString = leitor.next();
        valorInformado = Float.parseFloat(valorInformadoString.replace(",", "."));

        //trata o valor informado para converter ele em int
        valorInformado = valorInformado*100;
        valorpago = (int)valorInformado;

        this.contas.forEach(conta -> {

            //grava transferencia para o pagante
            if(idpaga == conta.getId()){
                if(conta.getSaldo() < valorpago) {
                    try {
                        throw new LowBalanceException("Saldo Insuficiente");
                    } catch (LowBalanceException e) {
                        e.printStackTrace();
                    }
                } else {
                    conta.setSaldo(conta.getSaldo()-valorpago);
                    //Aloca a transferencia no extrato da conta que pagou
                    Conta contaRecebe = this.contas.stream().filter((Conta x )-> x.getId() == idrecebe).collect(Collectors.toList()).get(0);
                    conta.setExtrato(
                            new Transferencia(
                                    -valorpago,
                                    conta,
                                    contaRecebe
                            )
                    );
                    //Aloca a transferencia no extrato do cliente que pagou
                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                            -valorpago,
                                            cliente,
                                            this.contas.stream().filter(x-> x.getId() == idrecebe).collect(Collectors.toList()).get(0) //talvez tenha um erro aqui
                                    )
                            );
                    });
                }
            }

            //grava transferencia para o recebente
            //Aloca a transferencia no extrato da conta que pagou
            if(idrecebe == conta.getId()){
                conta.setSaldo(conta.getSaldo() + valorpago);
                conta.setExtrato(
                        new Transferencia(
                                +valorpago,
                                this.contas.stream().filter(x -> x.getId() == idpaga).collect(Collectors.toList()).get(0),
                                conta
                        )
                );

                //Aloca a transferencia no extrato do cliente que pagou
                this.clientes.forEach(cliente -> {
                    if(conta.getCpf() == cliente.getCpf())
                        cliente.setExtrato(
                                new Transferencia(
                                        +valorpago,
                                        this.contas.stream().filter(x -> x.getId() == idpaga).collect(Collectors.toList()).get(0),
                                        cliente
                                )
                        );
                });
            }
        });

        balancoFinal = this.calculaBalanco();

        if(balancoFinal != balancoInicial) {
            this.contas.forEach(conta -> {
                if(idpaga == conta.getId()) {
                    conta.setSaldo(conta.getSaldo() + valorpago);
                    conta.setExtrato(
                            new Transferencia(
                                    +valorpago,
                                    this.contas.stream().filter(x -> x.getId() == idrecebe).collect(Collectors.toList()).get(0),
                                    conta
                            )
                    );

                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                    +valorpago,
                                    this.contas.stream().filter(x->x.getId()==idrecebe).collect(Collectors.toList()).get(0),
                                    conta
                                    )
                            );
                    });
                }

                if(idrecebe == conta.getId()) {
                    conta.setSaldo(conta.getSaldo() - valorpago);
                    conta.setExtrato(
                            new Transferencia(
                                    -valorpago,
                                    conta,
                                    this.contas.stream().filter(x -> x.getId() == idpaga).collect(Collectors.toList()).get(0)
                            )
                    );

                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                            -valorpago,
                                            conta,
                                            this.contas.stream().filter(x->x.getId()==idpaga).collect(Collectors.toList()).get(0)
                                    )
                            );
                    });
                }
            });
            throw new WrongBalanceExpetion("O Balanco total do banco foi adulterado");
        }
    }

}
