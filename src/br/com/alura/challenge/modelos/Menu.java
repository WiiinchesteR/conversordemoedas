package br.com.alura.challenge.modelos;

import br.com.alura.challenge.api.ConsultaAPI;
import br.com.alura.challenge.logs.Leitura;
import br.com.alura.challenge.logs.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menuDeOpcoes() throws IOException, InterruptedException {
        // Instânciando o objeto scanner para receber a leitura do teclado.
        Scanner scanner = new Scanner(System.in);

        // Instânciando o objeto para consultar a API e realizar tais cálculos.
        ConsultaAPI consultaAPI = new ConsultaAPI();

        // Instânciando o objeto para salvar os dados da pesquisa num log.txt.
        Log log = new Log();

        // Instânciando o objeto para criar uma lista e adicionar o log para ser exibido no console.
        List<String> listaDeLog = new ArrayList<>();

        // Enquanto for verdadeiro, faça...
        while (true) {
            try {
                // Menu de opções
                System.out.println("============================================");
                System.out.println("[1] - (USD) Dólar para (BRL) Real Brasileiro");
                System.out.println("[2] - (BRL) Real Brasileiro para (USD) Dólar");
                System.out.println("[3] - (USD) Dólar para (ARS) Peso Argentino");
                System.out.println("[4] - (ARS) Peso Argentino para (USD) Dólar");
                System.out.println("[5] - (USD) Dólar para (EUR) Euro");
                System.out.println("[6] - (EUR) Euro para (USD) Dólar");
                System.out.println("[7] - (USD) Dólar para (GBP) Libras");
                System.out.println("[8] - (GBP) Libras para (USD) Dólar");
                System.out.println("============================================");
                System.out.println("[9] - Mostrar histórico de conversão");
                System.out.println("[10] - Sair da aplicação");
                System.out.print("Digite a opção ==> ");

                // Criando variável opção do tipo string para converte-la e trata-la caso
                // o usuário digite algo além de números inteiros.
                String opcao = scanner.next();
                int opcaoInt = Integer.parseInt(opcao);

                if (opcaoInt == 10) {
                    // Se o usuário digitar 10, o programa encerra.
                    System.out.println();
                    System.out.println("Saindo do programa...");
                    break;
                } else if (opcaoInt <= 0 || opcaoInt > 10) {
                    // Se o usuário digitar, abaixo de 0 e acima de 10, o programa volta pro loop.
                    System.out.println();
                    System.out.println("Opção inválida!");
                    System.out.println();
                    continue;
                } else if (opcaoInt == 9) {
                    // Se o usuário digitar 9, o programa irá exibir no console, o histórico atual.
                    if (listaDeLog.isEmpty()) {
                        // Coloque o mesmo caminho da classe Log.
                        String caminho = "C:\\Users\\Davi Moraes\\Estudos\\conversordemoedas\\src\\br\\com\\alura\\" +
                                "challenge\\logs\\log.txt";

                        Leitura leitura = new Leitura();

                        leitura.leituraLog(caminho);
                        continue;
                    } else {
                        // Varrendo a lista para ser impressa.
                        System.out.println();
                        for (String lista : listaDeLog) {
                            System.out.println(lista);
                        }
                        System.out.println();
                        continue;
                    }
                }

                // Entrada do usuário.
                System.out.println();
                System.out.print("Digite o valor a ser convertido: ");

                // Criando variável valor do tipo string para converte-la e trata-la caso
                // o usuário digite algo além de números inteiros.
                String valor = scanner.next();
                double valorDouble = Double.parseDouble(valor);

                System.out.println();

                // Menu de opções utilizando switch-case.
                switch (opcaoInt) {
                    case 1:
                        System.out.println(String.format("""
                                Valor convertido: R$%.2f
                                """, consultaAPI.conversao("USD", "BRL", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("USD", "BRL", valorDouble),
                                "Dólar ==> Real Brasileiro"
                        ));
                        break;
                    case 2:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, consultaAPI.conversao("BRL", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("BRL", "USD", valorDouble),
                                "Real Brasileiro ==> Dólar"
                        ));
                        break;
                    case 3:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, consultaAPI.conversao("USD", "ARS", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("USD", "ARS", valorDouble),
                                "Dólar ==> Peso Argentino"
                        ));
                        break;
                    case 4:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, consultaAPI.conversao("ARS", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("ARS", "USD", valorDouble),
                                "Peso Argentino ==> Dólar"
                        ));
                        break;
                    case 5:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, consultaAPI.conversao("USD", "EUR", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("USD", "EUR", valorDouble),
                                "Dólar ==> Euro"
                        ));
                        break;
                    case 6:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, consultaAPI.conversao("EUR", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("EUR", "USD", valorDouble),
                                "Euro ==> Dólar"
                        ));
                        break;
                    case 7:
                        System.out.println(String.format("""
                                Valor convertido: $%.2f
                                """, consultaAPI.conversao("USD", "GBP", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("USD", "GBP", valorDouble),
                                "Dólar ==> Libras"
                        ));
                        break;
                    case 8:
                        System.out.println(String.format("""
                                Valor convertido: £%.2f
                                """, consultaAPI.conversao("GBP", "USD", valorDouble)));

                        listaDeLog.add(log.salvar(
                                valorDouble, consultaAPI.conversao("GBP", "USD", valorDouble),
                                "Libras ==> Dólar"
                        ));
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Digite somente números inteiros...");
                System.out.println();
            }
        }
    }
}
