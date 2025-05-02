package br.com.alura.challenge.logs;

import java.io.File;
import java.util.Scanner;

public class Leitura {

    public void leituraLog(String string) {
        // Instâciando o objeto arquivo, para receber uma string do caminho do arquivo.
        File arquivo = new File(string);

        //Tratando a leitura do arquivo
        try {
            Scanner scanner = new Scanner(arquivo);
            // Caso o arquivo exista, e tenha mais 1 caractere, então não está vazio.
            if (arquivo.exists() && arquivo.length() > 0) {
                // While para ler o arquivo, linha por linha.
                System.out.println();
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    System.out.println(linha);
                }
                System.out.println("-----------------------------------------------------------------------");
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Histórico vazio...");
                System.out.println();
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
