package com.example.climalert.scheduler;

import com.example.climalert.alerta.ServiceAlerta;
import com.example.climalert.clima.RepositoryRegistroClima;
import com.example.climalert.clima.ServiceClima;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerClima {

    private final ServiceClima climaService;
    private final ServiceAlerta alertaService;
    private final RepositoryRegistroClima repositoryRegistroClima;

    public SchedulerClima(
            ServiceClima climaService,
            ServiceAlerta alertaService,
            RepositoryRegistroClima repositoryRegistroClima
    ) {
        this.climaService = climaService;
        this.alertaService = alertaService;
        this.repositoryRegistroClima = repositoryRegistroClima;
    }

    @Scheduled(fixedRate = 300000)
    public void obtenerDatosClimaticos() {

        climaService.obtenerClimaActual();

        repositoryRegistroClima.findTopByOrderByFechaHoraDesc()
                .ifPresent(registro -> System.out.println(
                        "Temperatura: " + registro.getTemperatura()
                                + " Humedad: " + registro.getHumedad()
                ));
    }

    @Scheduled(fixedRate = 60000)
    public void analizarCondiciones() {

        repositoryRegistroClima.findTopByOrderByFechaHoraDesc()
                .ifPresent(registro -> {

                    if (alertaService.esCondicionCritica(registro)) {
                        System.out.println("ALERTA CLIMATICA DETECTADA");
                    }

                });
    }
}