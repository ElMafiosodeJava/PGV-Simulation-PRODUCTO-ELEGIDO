package net.experimento_2.subwai.salesianos;

import net.experimento_2.subwai.entities.Consumer;
import net.experimento_2.subwai.entities.Producer;
import net.experimento_2.subwai.entities.SharedBuffer;

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

        // PRODUCCIÓN MUCHO MÁS RÁPIDA
        int maxProduccion = 200;   // muy corto
        int maxConsumo = 1000;     // más lento

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

        System.out.println("Experimento 2 terminado.");
    }
}
