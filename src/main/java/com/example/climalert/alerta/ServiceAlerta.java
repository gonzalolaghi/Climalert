package com.example.climalert.alerta;

import com.example.climalert.clima.RegistroClima;
import org.springframework.stereotype.Service;

@Service
public class ServiceAlerta {

    public boolean esCondicionCritica(RegistroClima registro) {

        return registro.getTemperatura() > 35
                && registro.getHumedad() > 60;
    }
}