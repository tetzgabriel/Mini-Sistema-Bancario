# Mini Sistema Bancário

### Colaboradores
Gabriel Tetzlaf <br>
Pedro Potenza

## Introdução
Neste projeto de trabalho, o/a aluno(a) deverá implementar um pequeno sistema bancário com menu de console.

## Motivação
No currículo 1998, esta disciplina é nomeada "Linguagens Comerciais de Programação". Antes de 1998, alunos costumeiramente aprendiam a "Linguagem Comum Orientada para os Negócios" (COBOL) e muitos dos exemplos eram focados em sistemas bancários.

## Justificativa
A vantagem de implementar um sistema bancário é sua importância intrínseca de auditoria contábil, que ensina os alunos a escrever testes de forma natural.

## Projeto e Requisitos
Implemente um sistema bancário simplista. Neste sistema, devem ser gerenciados os seguintes conceitos:
### Conceitos:
Banco (só uma agência com vários clientes)
Cliente (do banco, pode ter várias contas)
Conta (de um cliente)
Transferência (entre duas contas)
### Caso de uso:
O/a operador(a) do sistema (não precisa ser identificado(a)) usa menus de texto.
Nestes menus, ele(a) pode selecionar a operação:
Lista clientes;
Lista contas;
Saldo do cliente (ou da conta);
Extrato do cliente (ou da conta);
Realizar transferência entre contas;
Mostrar valores totais de todas as contas.
As contas começam já com valores padrão, exemplo, 1000 reais para cada cliente.
O banco não recebe valores de fora, nem envia valores para fora. Depois de criar todas as contas no construtor, calcule o somatório total dos saldos. Este total deve ser constante. Ou seja, todas as transferências devem ser testadas com o total de todas as contas, antes e depois e verificar se o balanço é mantido.
Lance tipos específicos de exceções, como por exemplo, ao detectar número de contas inválido e falta de saldo para transferências. Use o tratamento de exceções para exibir mensagens ao operador.
Escreva JavaDocs para todos: Classes, Interfaces e Métodos/Operações.
### Linguagem: Java 8 (2014).