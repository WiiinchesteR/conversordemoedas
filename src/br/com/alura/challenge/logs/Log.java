package br.com.alura.challenge.logs;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Log {

    // Metodo para criar um arquivo de log simples, utilizando arquivo com extensão .txt.
    public String salvar(double valorIntroduzido, double valorConverdito, String txt) {
        // Váriavel texto está recebendo uma string formatada que é mostrada no arquivo log.txt.
        String texto = String.format("""
                -----------------------------------------------------------------------
                %s
                Valor introduzido pelo usuário: %.2f
                Valor convertido: %.2f
                """, txt, valorIntroduzido, valorConverdito);

        // Aqui ficará o caminho exato onde o arquivo log.txt está.
        // Se for testar o código e utiliza Windows como SO, apenas altere alguns caminhos até chegar no log.txt.
        // Para funcionar a escrita no arquivo, é necessário o arquivo já existir, estará no git.
        String caminho = "C:\\Users\\Davi Moraes\\Estudos\\conversordemoedas\\src\\br\\com\\alura\\" +
                "challenge\\logs\\log.txt";

        // Tratando exceções.
        try {
             Files.write(Paths.get(caminho), texto.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return texto;
    }
}
