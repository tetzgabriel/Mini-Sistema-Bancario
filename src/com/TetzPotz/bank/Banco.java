package com.TetzPotz.bank;

import com.TetzPotz.bank.Exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Banco {
    private int numeroAgencias;
    private int balanco;
    private int id;

    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    public Banco(int numeroAgencias) {
        this.numeroAgencias = numeroAgencias;
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
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

    public int calculaBalanco() {
        if (this.contas.isEmpty()){
            return 0;
        } else {
            int balancoLocal = 0, i = 0;

            for (i = 0; i < this.contas.size(); i++) {
                balancoLocal += this.contas.get(i).getSaldo(); //this.contas[i] nao funciona por ser ArrayList
            }
            return balancoLocal;
        }
    }

    public void adicionaCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionaConta(Conta conta) {
        this.contas.add(conta);
    }

    public void showClientes() {
//        for (i = 0; i < this.clientes.size(); i++){
//            System.out.println("-----Cliente "+ i+1 + "-----");
//            System.out.println("Nome do cliente: " + this.clientes.get(i).getNome());
//            System.out.println("CPF do cliente: " + this.clientes.get(i).getCpf());
//        }

        this.clientes.forEach(cliente -> { // foreach = funcao do ArrayList
            System.out.println("\n-----Cliente-----");
            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("CPF do cliente: " + cliente.getCpf());
        });
    }

    public void showContas() {
        this.contas.forEach(conta -> { // foreach = funcao do ArrayList
            System.out.println("\n-----Conta "+ conta.getId() +"-----");
            System.out.println("Nome do titular da conta: " + conta.getNome());
            System.out.println("CPF do titular da conta: " + conta.getCpf());
        });
    }

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
            System.out.println("Saldo do cliente: "+ saldoLocal.get()/100);
        } else {
            throw new UserNotFoundException("Usuario nao encontrado");
        }
    }

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
            System.out.println("Saldo da conta: "+ saldoLocal.get()/100);
        } else {
            throw new AccountNotFoundException("Conta nao encontrada");
        }
    }

    public void extratoClienteStart() {
        AtomicInteger numContas = new AtomicInteger();

        this.clientes.forEach(cliente -> {
            this.contas.forEach(conta -> {
                if(cliente.getCpf() == conta.getCpf()) numContas.getAndIncrement();
            });
        });

        for (int i = 0; i < numContas.get(); i++) {
            this.clientes.get(i).setExtrato(new Transferencia(100000));
        }

        numContas.set(0);
    }

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

        balancoInicial = this.calculaBalanco();

        System.out.println("Id da conta que envia: ");
        idpaga = leitor.nextInt();

        System.out.println("Id da conta que recebe: ");
        idrecebe = leitor.nextInt();

        System.out.println("Valor que deseja transferir: ");
        valorInformado = leitor.nextFloat();

        valorInformado = valorInformado*100;
        valorpago = (int)valorInformado;

        this.contas.forEach(conta -> {
            if(idpaga == conta.getId()){
                encontroupaga.set(1);
                if(conta.getSaldo() < valorpago) {
                    try {
                        throw new LowBalanceException("Saldo Insuficiente");
                    } catch (LowBalanceException e) {
                        e.printStackTrace();
                    }
                } else {
                    conta.setSaldo(conta.getSaldo()-valorpago);
                    Conta contaPagante = this.contas.stream().filter((Conta x )-> x.getId() == idrecebe).collect(Collectors.toList()).get(0);
                    conta.setExtrato(
                            new Transferencia(
                                    -valorpago,
                                    conta,
                                    contaPagante
                            )
                    );

                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                            -valorpago,
                                            cliente,
                                            this.contas.stream().filter(x-> x.getId() == idrecebe).collect(Collectors.toList()).get(0)
                                    )
                            );
                    });
                }
            }

            if(idrecebe == conta.getId()){
                encontrourecebe.set(2);
                conta.setSaldo(conta.getSaldo() + valorpago);
                conta.setExtrato(
                        new Transferencia(
                                +valorpago,
                                conta,
                                this.contas.stream().filter(x -> x.getId() == idrecebe).collect(Collectors.toList()).get(0)
                        )
                );

                this.clientes.forEach(cliente -> {
                    if(conta.getCpf() == cliente.getCpf())
                        cliente.setExtrato(
                                new Transferencia(
                                        +valorpago,
                                        cliente,
                                        this.contas.stream().filter(x -> x.getId() == idrecebe).collect(Collectors.toList()).get(0)
                                )
                        );
                });
            }
        });

        if(encontroupaga.get() != 1) {
            this.contas.forEach(conta -> {
                if(idrecebe == conta.getId()){
                    conta.setSaldo(conta.getSaldo() - valorpago);
                    conta.setExtrato(
                            new Transferencia(
                                    -valorpago,
                                    conta,
                                    this.contas.stream().filter(x -> x.getId() == idrecebe).collect(Collectors.toList()).get(0)
                            )
                    );

                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                            -valorpago,
                                            conta,
                                            this.contas.stream().filter(x->x.getId()==idrecebe).collect(Collectors.toList()).get(0)
                                    )
                            );
                    });
                }
            });
            throw new UserNotFoundException("Usuario nao encontrado");
        }

        if(encontrourecebe.get() != 2) {
            this.contas.forEach(conta -> {
                if(idpaga == conta.getId()) {
                    conta.setSaldo((conta.getSaldo() + valorpago));
                    conta.setExtrato(
                            new Transferencia(
                                    +valorpago,
                                    conta,
                                    this.contas.stream().filter(x -> x.getId() == idrecebe).collect(Collectors.toList()).get(0)
                            )
                    );

                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                        +valorpago,
                                        conta,
                                        this.contas.stream().filter(x->x.getId()==idrecebe).collect(Collectors.toList()).get(0)
                                    )
                            );
                    });
                }
            });

            throw new UserNotFoundException("Usuario nao encontrado");
        }

        balancoFinal = this.calculaBalanco();

        if(balancoFinal != balancoInicial) {
            this.contas.forEach(conta -> {
                if(idpaga == conta.getId()) {
                    conta.setSaldo(conta.getSaldo() + valorpago);
                    conta.setExtrato(
                            new Transferencia(
                                    +valorpago,
                                    conta,
                                    this.contas.stream().filter(x -> x.getId() == idrecebe).collect(Collectors.toList()).get(0)
                            )
                    );

                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                    +valorpago,
                                    conta,
                                    this.contas.stream().filter(x->x.getId()==idrecebe).collect(Collectors.toList()).get(0)
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
                                    this.contas.stream().filter(x -> x.getId() == idrecebe).collect(Collectors.toList()).get(0)
                            )
                    );

                    this.clientes.forEach(cliente -> {
                        if(conta.getCpf() == cliente.getCpf())
                            cliente.setExtrato(
                                    new Transferencia(
                                            -valorpago,
                                            conta,
                                            this.contas.stream().filter(x->x.getId()==idrecebe).collect(Collectors.toList()).get(0)
                                    )
                            );
                    });
                }
            });
            throw new WrongBalanceExpetion("O Balanco total do banco foi adulterado");
        }
    }

}
