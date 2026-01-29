package net.experimento_2.subwai.salesianos;

import net.experimento_2.subwai.entities.Consumidor;
import net.experimento_2.subwai.entities.Productor;
import net.experimento_2.subwai.entities.Almacen;

public class Main {

    public static void main(String[] args) {
        int capacidadAlmacen = 5;
        Almacen almacen = new Almacen(capacidadAlmacen);

        String[] tipos = {
                "Tomate", "Lechuga", "Zanahoria", "Pepino", "Pimiento",
                "Calabacín", "Berenjena", "Cebolla", "Ajo", "Coliflor"
        };

        int productosAProducir = 10;
        int productosAConsumir = 10;

        int maxProduccion = 200;   
        int maxConsumo = 1000;    

        Productor productor = new Productor("Juan", almacen,
                productosAProducir, tipos, maxProduccion);

        Consumidor consumidor = new Consumidor("Paco", almacen,
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
