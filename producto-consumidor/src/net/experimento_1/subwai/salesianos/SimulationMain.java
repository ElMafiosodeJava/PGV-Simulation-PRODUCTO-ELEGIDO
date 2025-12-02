package net.experimento_1.subwai.salesianos;

import net.experimento_1.subwai.entities.Consumer;
import net.experimento_1.subwai.entities.Producer;
import net.experimento_1.subwai.entities.SharedBuffer;

public class SimulationMain {

    public static void main(String[] args) {
        int capacidadAlmacen = 3; // por ejemplo
        SharedBuffer almacen = new SharedBuffer(capacidadAlmacen);

        String[] tipos = {
                "Tomate", "Lechuga", "Zanahoria", "Pepino", "Pimiento",
                "Calabacín", "Berenjena", "Cebolla", "Ajo", "Coliflor"
        };

        int productosAProducir = 5;
        int productosAConsumir = 5;

        int maxProduccion = 800;  // ms
        int maxConsumo = 700;     // ms

        Producer productor = new Producer("Juan", almacen,
                productosAProducir, tipos, maxProduccion);

        Consumer consumidor = new Consumer("Paco", almacen,
                productosAConsumir, maxConsumo);

        productor.start();
        consumidor.start();

        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Experimento 1 terminado.");
    }
}
