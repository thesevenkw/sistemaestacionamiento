package com.example.sistemaestacionamiento;

import java.time.LocalDateTime;

public class Vehiculo {
    public String placa;
    public LocalDateTime horaEntrada;

    public Vehiculo(String placa) {
        this.placa = placa;
    }
}