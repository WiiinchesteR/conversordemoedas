package br.com.alura.challenge.principal;

import br.com.alura.challenge.modelos.Menu;

import java.io.IOException;

// Challange conversor de moedas.
// Site utilizado para o consumo da API https://www.exchangerate-api.com/
// Crie uma conta e resgate uma chave, coloque a chave na classe ConsultaAPI.java
// Altere também o caminho do arquivo log, para funcionar corretamente
// O caminho do log precisa ser alterado nas classes Log.java e Menu.java
// Turma G8 Oracle, Alura.
// Me chamo Davi Moraes, sou estudante de Engenharia de Software na Cruzeiro do Sul.

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Instânciando objeto.
        Menu menu = new Menu();

        System.out.println("-=-=-=-=-=-= CONVERSOR DE MOEDAS -=-=-=-=-=-=");
        System.out.println();

        // Menu de opções que aparece no console.
        menu.menuDeOpcoes();
    }
}
