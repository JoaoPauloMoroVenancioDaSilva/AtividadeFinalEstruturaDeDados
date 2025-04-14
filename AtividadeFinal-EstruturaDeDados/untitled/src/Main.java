import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDinamica listaDinamica = new ListaDinamica();
        int opcao;

        System.out.println("Olá, bem-vindo ao gerenciador de Listas Dinâmicas! Você poderá criar 1 lista e " +
                "modifica-lá. " +
                "Para mexer com outra, será necessário rodar o programa novamente. Muito obrigado.");

        do {
            System.out.println("\nEscolha a sua opção:\n" +
                    "1 - Inserir valor\n" +
                    "2 - Inserir valor em sequência\n" +
                    "3 - Remover valor\n" +
                    "4 - Remover valor por sequência\n" +
                    "5 - Remover todas as ocorrências\n" +
                    "6 - Verificar se a lista está cheia \n" +
                    "7 - Verificar se a lista está vazia \n" +
                    "8 - Buscar elemento\n" +
                    "9 - Ordenar crescente\n" +
                    "10 - Ordenar decrescente\n" +
                    "11 - Ver quantidade de elementos\n" +
                    "12 - Editar elemento\n" +
                    "13 - Limpar lista\n" +
                    "14 - Ver lista\n" +
                    "15  - Ver qual é o primeiro elemento\n" +
                    "16  - Ver qual é o último elemento\n" +
                    "17 - Sair");
            System.out.print("Escolha a opção ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um número para inserir: ");
                    int valorInserir = scanner.nextInt();
                    listaDinamica.inserirElemento(valorInserir);
                    break;

                case 2:
                    System.out.print("Quantos valores deseja inserir? ");
                    int qtd = scanner.nextInt();
                    ListaDinamica novaLista = new ListaDinamica();
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Digite o valor " + (i + 1) + ": ");
                        int valor = scanner.nextInt();
                        novaLista.inserirElemento(valor);
                    }
                    listaDinamica.inserirSequencia(novaLista);
                    System.out.println("Sequência adicionada à lista.");
                    break;

                case 3:
                    if (listaDinamica.estaVazia()) {
                        System.out.println("A lista está vazia. Impossível remover um valor.");
                    }else {
                        System.out.print("Digite o número que deseja remover: ");
                        int valorRemover = scanner.nextInt();
                        boolean removido = listaDinamica.removerElemento(valorRemover);
                        if (removido) {
                            System.out.println("Elemento removido com sucesso.");
                        } else {
                            System.out.println("Elemento não encontrado.");
                        }
                    }
                    break;

                case 4:
                    if (listaDinamica.estaVazia()) {
                        System.out.println("A sua Lista está vazia. Insira um número primeiro.");
                    }else {
                        System.out.print("Quantos valores deseja remover? ");
                        int quantidade = scanner.nextInt();
                        Integer[] valores = new Integer[quantidade];
                        for (int i = 0; i < quantidade; i++) {
                            System.out.print("Digite o valor " + (i + 1) + ": ");
                            valores[i] = scanner.nextInt();
                        }
                        listaDinamica.removerSequencia(valores);
                    }
                    break;

                case 5:
                    if (listaDinamica.estaVazia()) {
                        System.out.println("A sua Lista está vazia. Insira um número primeiro.");
                    }else {
                        System.out.print("Digite o valor que deseja remover de todas as ocorrências: ");
                        int valorOcorrencia = scanner.nextInt();
                        listaDinamica.removerTodasOcorrencias(valorOcorrencia);
                    }
                    break;

                case 6:
                    listaDinamica.estaCheia();
                    break;

                case 7:
                    if (listaDinamica.estaVazia()) {
                        System.out.println("A sua Lista Dinamica está vazia.");
                    } else {
                        System.out.println("A sua Lista contém elementos.");
                    }
                    break;

                case 8:
                    System.out.print("Digite o valor para buscar: ");
                    int valorBuscar = scanner.nextInt();
                    boolean encontrado = listaDinamica.buscarElemento(valorBuscar);
                    if (encontrado) {
                        System.out.println("Elemento encontrado na lista.");
                    } else {
                        System.out.println("Elemento não está na lista.");
                    }
                    break;

                case 9:
                    listaDinamica.ordenarCrescente();
                    System.out.println("Lista ordenada em ordem crescente.");
                    break;

                case 10:
                    listaDinamica.ordenarDecrescente();
                    System.out.println("Lista ordenada em ordem decrescente.");
                    break;

                case 11:
                    System.out.println("Quantidade de elementos: " + listaDinamica.quantidadeElementos());
                    break;

                case 12:
                    if (listaDinamica.estaVazia()) {
                        System.out.println("A sua Lista está vazia. Insira um número primeiro.");
                    }else {
                        System.out.print("Digite o valor antigo: ");
                        int antigo = scanner.nextInt();
                        System.out.print("Digite o novo valor: ");
                        int novo = scanner.nextInt();
                        listaDinamica.editarElemento(antigo, novo);
                        System.out.println("Se o valor existia, foi editado.");
                    }
                    break;

                case 13:
                    listaDinamica.limpar();
                    System.out.println("Lista limpa com sucesso.");
                    break;

                case 14:
                    listaDinamica.exibir();
                    break;

                case 15:
                    if (!listaDinamica.estaVazia()) {
                        System.out.println("Primeiro elemento: " + listaDinamica.obterPrimeiroElemento().getConteudo());
                    } else {
                        System.out.println("A sua Lista está vazia.");
                    }
                    break;

                case 16:
                    if (!listaDinamica.estaVazia()) {
                        System.out.println("Último elemento: " + listaDinamica.obterUltimoElemento().getConteudo());
                    } else {
                        System.out.println("A sua Lista está vazia.");
                    }
                    break;

                case 17:
                    System.out.println("Fim do programa. Muito obrigado por ter utilizado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 17);

    }
}
