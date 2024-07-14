package service;

import com.google.gson.Gson;
import model.ExchangeRate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    private static final  String url = "https://v6.exchangerate-api.com/v6/b4e714e79ae1ad1435826908/";

    public ExchangeRate exchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + fromCurrency + "/" + toCurrency))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), ExchangeRate.class);

    }

}
