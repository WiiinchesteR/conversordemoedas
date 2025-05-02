package br.com.alura.challenge.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    // Instânciando em modo privado o gson para extrair os dados Json.
    private Gson gson = new Gson();
    // Aqui, coloque sua chave para testar a aplicação.
    private String SUA_CHAVE = "";

    // Metodo para consumir a API e realizar os cálculos da moeda.
    public double conversao(
            String converterDe, String converterPara, double valor
    ) throws IOException, InterruptedException {
        // URL em formatado string com sua chave da API.
        String link = "https://v6.exchangerate-api.com/v6/" + this.SUA_CHAVE + "/latest/" + converterDe;

        // Acessando API
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Variável json está recebendo o Json que veio da API.
        String json = response.body();

        // Acessando o inteior do Json.
        JsonObject jsonObject = this.gson.fromJson(json, JsonObject.class);

        // Acessando o tipo de moeda dentro do Json.
        JsonObject taxas = jsonObject.getAsJsonObject("conversion_rates");

        // Pegando o valor dessa moeda.
        double taxa = taxas.get(converterPara).getAsDouble();

        // Realizando o cálculo de conversão.
        return valor * taxa;
    }
}
