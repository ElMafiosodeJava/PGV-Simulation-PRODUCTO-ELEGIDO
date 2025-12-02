import net.subwai.entities.Consumer;
import net.subwai.entities.Producer;
import net.subwai.entities.SharedBuffer;

public class SimulationMain {

    public static void main(String[] args) {

        // Capacidad del recurso compartido (puestito / almacén)
        int capacidadAlmacen = 5;
        SharedBuffer almacen = new SharedBuffer(capacidadAlmacen);

        // Tipos de productos (al menos 10)
        String[] tiposVerdura = {
                "Tomate", "Lechuga", "Zanahoria", "Pepino", "Pimiento",
                "Calabacín", "Berenjena", "Cebolla", "Ajo", "Coliflor"
        };

        int productosPaco = 10;
        int productosRamon = 10;

        // Tiempo máximo de producción (mismo para todos los productores)
        int maxTiempoProduccionMs = 1000;

        // Productores
        Producer paco = new Producer("Paco", almacen, productosPaco,
                tiposVerdura, maxTiempoProduccionMs);

        Producer ramon = new Producer("Ramón", almacen, productosRamon,
                tiposVerdura, maxTiempoProduccionMs);

        // Tiempo máximo de consumo por cliente (propio de cada uno)
        Consumer faustino = new Consumer("Faustino", almacen, 5, 800);
        Consumer mrGentleman = new Consumer("Mr. Gentleman", almacen, 10, 900);
        Consumer loquendo = new Consumer("Loquendo", almacen, 5, 700);

        // Iniciar hilos
        paco.start();
        ramon.start();

        faustino.start();
        mrGentleman.start();
        loquendo.start();

        // Esperar a que todos terminen
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


