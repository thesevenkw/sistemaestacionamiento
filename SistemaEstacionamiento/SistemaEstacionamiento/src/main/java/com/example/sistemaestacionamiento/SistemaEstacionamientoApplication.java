package com.example.sistemaestacionamiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner; // Importante para leer el teclado

@SpringBootApplication
public class SistemaEstacionamientoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaEstacionamientoApplication.class, args);

        // Creamos el Scanner y el Estacionamiento
        Scanner teclado = new Scanner(System.in);
        Estacionamiento miCochera = new Estacionamiento(5);
        int opcion = 0;

        System.out.println("\n=== BIENVENIDO AL SISTEMA DE JULIACA ===");

        // El bucle "do-while" mantiene el programa vivo hasta que elijas salir
        do {
            System.out.println("\n--- MENÚ DE CONTROL ---");
            System.out.println("1. Registrar Entrada de Vehículo");
            System.out.println("2. Registrar Salida (Cobrar)");
            System.out.println("3. Ver Espacios Disponibles");
            System.out.println("4. Generar Reporte de Caja");
            System.out.println("5. Salir del Programa");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt(); // Lee el número que escribas

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la PLACA del vehículo: ");
                    String placaEntrada = teclado.next();
                    miCochera.registrarEntrada(new Vehiculo(placaEntrada));
                    break;
                case 2:
                    System.out.print("Ingrese la PLACA que sale: ");
                    String placaSalida = teclado.next();
                    miCochera.registrarSalida(placaSalida);
                    break;
                case 3:
                    miCochera.mostrarDisponibilidad();
                    break;
                case 4:
                    miCochera.generarReporteDiario();
                    break;
                case 5:
                    System.out.println("Cerrando sistema... ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 5);

        teclado.close(); // Cerramos el scanner al terminar
    }
}