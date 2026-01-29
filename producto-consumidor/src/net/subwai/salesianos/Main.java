import net.subwai.entities.Consumidor;
import net.subwai.entities.Productor;
import net.subwai.entities.Almacen;

public class Main {

    public static void main(String[] args) {

        int capacidadAlmacen = 5;
        Almacen almacen = new Almacen(capacidadAlmacen);

        String[] tiposVerdura = {
                "Tomate", "Lechuga", "Zanahoria", "Pepino", "Pimiento",
                "Calabacín", "Berenjena", "Cebolla", "Ajo", "Coliflor"
        };

        int productosPaco = 10;
        int productosRamon = 10;

        int maxTiempoProduccionMs = 1000;

        Productor paco = new Productor("Paco", almacen, productosPaco,
                tiposVerdura, maxTiempoProduccionMs);

        Productor ramon = new Productor("Ramón", almacen, productosRamon,
                tiposVerdura, maxTiempoProduccionMs);

        Consumidor faustino = new Consumidor("Faustino", almacen, 5, 800);
        Consumidor mrGentleman = new Consumidor("Mr. Gentleman", almacen, 10, 900);
        Consumidor loquendo = new Consumidor("Loquendo", almacen, 5, 700);

        paco.start();
        ramon.start();

        faustino.start();
        mrGentleman.start();
        loquendo.start();

        try {
            paco.join();
            ramon.join();
            faustino.join();
            mrGentleman.join();
            loquendo.join();
        } catch (InterruptedException e) {
            System.out.println("La simulación fue interrumpida.");
            Thread.currentThread().interrupt();
        }

        System.out.println("Simulación terminada. Todos han producido y consumido sus productos.");
    }
}


