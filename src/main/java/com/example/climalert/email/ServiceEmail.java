package com.example.climalert.email;

import com.example.climalert.clima.RegistroClima;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmail {

    private final JavaMailSender javaMailSender;

    public ServiceEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarAlerta(RegistroClima registro) {

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(
                "admin@clima.com",
                "emergencias@clima.com",
                "meteorologia@clima.com"
        );

        mensaje.setSubject("ALERTA CLIMATICA");

        mensaje.setText(
                "Se detectaron condiciones climaticas criticas.\n\n"
                        + "Temperatura: " + registro.getTemperatura() + "°C\n"
                        + "Humedad: " + registro.getHumedad() + "%\n"
                        + "Fecha: " + registro.getFechaHora()
        );

        javaMailSender.send(mensaje);
    }
}