package com.example.climalert.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPrueba {

    private final ClienteWeatherApi clienteWeatherApi;

    public ControllerPrueba(ClienteWeatherApi clienteWeatherApi) {
        this.clienteWeatherApi = clienteWeatherApi;
    }

    @GetMapping("/prueba")
    public RespuestaClima prueba() {
        return clienteWeatherApi.obtenerClimaActual();
    }
}