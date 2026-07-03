package com.example.climalert.clima;

import com.example.climalert.weather.ClienteWeatherApi;
import com.example.climalert.weather.RespuestaClima;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServiceClima {

    private final ClienteWeatherApi clienteWeatherApi;
    private final RepositoryRegistroClima registroClimaRepository;

    public ServiceClima(
            ClienteWeatherApi clienteWeatherApi,
            RepositoryRegistroClima registroClimaRepository
    ) {
        this.clienteWeatherApi = clienteWeatherApi;
        this.registroClimaRepository = registroClimaRepository;
    }

    public RegistroClima obtenerClimaActual() {

        RespuestaClima respuesta = clienteWeatherApi.obtenerClimaActual();

        RegistroClima registro = new RegistroClima(
                respuesta.current().temp_c(),
                respuesta.current().humidity(),
                LocalDateTime.now()
        );

        return registroClimaRepository.save(registro);
    }

}