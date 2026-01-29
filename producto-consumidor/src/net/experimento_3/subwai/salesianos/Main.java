package net.experimento_3.subwai.salesianos;

import net.experimento_3.subwai.entities.Consumidor;
import net.experimento_3.subwai.entities.Productor;
import net.experimento_3.subwai.entities.Almacen;

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

        int maxProduccion = 800; 
        int maxConsumo = 800;    

        Productor productor = new Productor("Productor-PRIORITARIO", almacen,
                productosAProducir, tipos, maxProduccion);

        Consumidor consumidor = new Consumidor("Consumidor-NORMAL", almacen,
                productosAConsumir, maxConsumo);

        
        productor.setPriority(Thread.MAX_PRIORITY);
        consumidor.setPriority(Thread.NORM_PRIORITY); 

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
