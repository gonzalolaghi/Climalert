package com.example.climalert.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ClienteWeatherApi {

    private final RestClient restClient;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.city}")
    private String ciudad;

    public ClienteWeatherApi() {
        this.restClient = RestClient.create();
    }

    public RespuestaClima obtenerClimaActual() {

        return restClient.get()
                .uri(
                        "https://api.weatherapi.com/v1/current.json?key={key}&q={city}",
                        apiKey,
                        ciudad
                )
                .retrieve()
                .body(RespuestaClima.class);
    }
}