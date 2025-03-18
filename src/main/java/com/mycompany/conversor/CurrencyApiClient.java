/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor;

/**
 *
 * @author berna
 */
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class CurrencyApiClient {
    private static final String BASE_URL = "https://api.exchangerate.host/convert"; // URL base da API
    private static final String ACCESS_KEY = "cec02de9e127996b27f81eb6265b6c55"; // Substitua por sua chave de acesso
    private static final OkHttpClient client = new OkHttpClient();

    public static double getExchangeRate(String fromCurrency, String toCurrency, double amount) throws IOException {
        // Construindo a URL com a chave de acesso e o valor da conversão
        String url = BASE_URL + "?from=" + fromCurrency + "&to=" + toCurrency + "&amount=" + amount + "&access_key=" + ACCESS_KEY;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro na requisição: " + response);
            }

            String responseData = response.body().string();
            System.out.println("Resposta da API: " + responseData); // Log da resposta completa

            JSONObject json = new JSONObject(responseData);

            if (json.has("result")) {
                return json.getDouble("result");
            } else {
                throw new IOException("A chave 'result' não foi encontrada na resposta da API.");
            }
        }
    }
}





