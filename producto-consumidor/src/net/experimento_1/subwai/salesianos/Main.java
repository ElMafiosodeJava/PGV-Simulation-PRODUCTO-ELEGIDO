package net.experimento_1.subwai.salesianos;

import net.experimento_1.subwai.entities.Consumidor;
import net.experimento_1.subwai.entities.Productor;
import net.experimento_1.subwai.entities.Almacen;

public class Main {

    public static void main(String[] args) {
        int capacidadAlmacen = 3; 
        Almacen almacen = new Almacen(capacidadAlmacen);

        String[] tipos = {
                "Tomate", "Lechuga", "Zanahoria", "Pepino", "Pimiento",
                "Calabacín", "Berenjena", "Cebolla", "Ajo", "Coliflor"
        };

        int productosAProducir = 5;
        int productosAConsumir = 5;

        int maxProduccion = 800;  
        int maxConsumo = 700;     

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

        System.out.println("Experimento 1 terminado.");
    }
}
