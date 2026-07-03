package com.example.climalert.clima;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RegistroClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperatura;

    private int humedad;

    private LocalDateTime fechaHora;

    public RegistroClima() {
    }

    public RegistroClima(
            double temperatura,
            int humedad,
            LocalDateTime fechaHora
    ) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.fechaHora = fechaHora;
    }

    public Long getId() {
        return id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}