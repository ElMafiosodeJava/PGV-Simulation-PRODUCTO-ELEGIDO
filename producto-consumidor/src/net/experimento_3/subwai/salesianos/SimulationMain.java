package net.experimento_3.subwai.salesianos;

import net.experimento_3.subwai.entities.Consumer;
import net.experimento_3.subwai.entities.Producer;
import net.experimento_3.subwai.entities.SharedBuffer;

public class SimulationMain {

    public static void main(String[] args) {
        int capacidadAlmacen = 5;
        SharedBuffer almacen = new SharedBuffer(capacidadAlmacen);

        String[] tipos = {
                "Tomate", "Lechuga", "Zanahoria", "Pepino", "Pimiento",
                "Calabacín", "Berenjena", "Cebolla", "Ajo", "Coliflor"
        };

        int productosAProducir = 10;
        int productosAConsumir = 10;

        int maxProduccion = 800; // tiempos "normales"
        int maxConsumo = 800;    // también

        Producer productor = new Producer("Productor-PRIORITARIO", almacen,
                productosAProducir, tipos, maxProduccion);

        Consumer consumidor = new Consumer("Consumidor-NORMAL", almacen,
                productosAConsumir, maxConsumo);

        // Establecer prioridades
        productor.setPriority(Thread.MAX_PRIORITY);
        consumidor.setPriority(Thread.NORM_PRIORITY); // o MIN_PRIORITY para exagerar

        productor.start();
        consumidor.start();

        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Experimento 3 terminado.");
    }
}
