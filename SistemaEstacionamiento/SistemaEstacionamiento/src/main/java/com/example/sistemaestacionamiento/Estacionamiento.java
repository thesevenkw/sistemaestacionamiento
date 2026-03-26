package com.example.sistemaestacionamiento;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;

public class Estacionamiento {
    private int capacidad;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private double recaudacionTotal = 0;

    public Estacionamiento(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean registrarEntrada(Vehiculo v) {
        if (vehiculos.size() < capacidad) {
            v.horaEntrada = LocalDateTime.now();
            vehiculos.add(v);
            System.out.println("Entrada registrada: " + v.placa);
            return true;
        }
        System.out.println("Error: Estacionamiento lleno.");
        return false;
    }

    public void registrarSalida(String placa) {
        Vehiculo encontrado = null;
        for (Vehiculo v : vehiculos) {
            if (v.placa.equalsIgnoreCase(placa)) {
                encontrado = v;
                break;
            }
        }

        if (encontrado != null) {
            // SIMULACIÓN: En lugar de Duration.between, usamos 45 minutos fijos
            long minutos = 45;
            double tarifa = minutos * 0.10;

            recaudacionTotal += tarifa;
            vehiculos.remove(encontrado);

            System.out.println("\n--- TICKET DE SALIDA ---");
            System.out.println("Placa: " + placa);
            System.out.println("Tiempo simulado: " + minutos + " min.");
            System.out.println("Tarifa aplicada: S/ 0.10 por min.");
            System.out.println("Total a pagar: S/ " + tarifa);
            System.out.println("------------------------");
        } else {
            System.out.println("Error: El vehículo con placa " + placa + " no está en el local.");
        }
    }

    public void mostrarDisponibilidad() {
        System.out.println("Espacios disponibles: " + (capacidad - vehiculos.size()));
    }

    public void generarReporteDiario() {
        System.out.println("\n********** REPORTE GENERAL **********");
        System.out.println("Recaudación acumulada: S/ " + recaudacionTotal);
        System.out.println("Autos dentro actualmente: " + vehiculos.size());
        System.out.println("************************************");
    }
}