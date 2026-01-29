package net.experimento_1.subwai.entities;

import java.util.Random;

public class Consumidor extends Thread{
    private final Almacen almacen;
    private final int cantidadAConsumir;
    private final int maxTiempoConsumoMs;
    private final Random random = new Random();

    public Consumidor(String nombre, Almacen almacen,
                    int cantidadAConsumir, int maxTiempoConsumoMs) {
        super(nombre);
        this.almacen = almacen;
        this.cantidadAConsumir = cantidadAConsumir;
        this.maxTiempoConsumoMs = maxTiempoConsumoMs;
    }

    @Override
    public void run() {
        for (int i = 1; i <= cantidadAConsumir; i++) {
            try {
                Producto product = almacen.take();

                int tiempo = random.nextInt(maxTiempoConsumoMs) + 1;
                Thread.sleep(tiempo);

                System.out.printf("[FIN CONSUMO] %s ha terminado de consumir %s%n",
                        getName(), product);

            } catch (InterruptedException e) {
                System.out.printf("Consumidor %s interrumpido.%n", getName());
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.printf("Consumidor %s ha terminado de consumir.%n", getName());
    }
}

