package net.subwai.entities;

import java.util.Random;

public class Producer extends Thread{
    private final SharedBuffer almacen;
    private final int cantidadAProducir;
    private final String[] tiposProducto;
    private final int maxTiempoProduccionMs;
    private final Random random = new Random();

    public Producer(String nombre, SharedBuffer almacen, int cantidadAProducir,
                    String[] tiposProducto, int maxTiempoProduccionMs) {
        super(nombre);
        this.almacen = almacen;
        this.cantidadAProducir = cantidadAProducir;
        this.tiposProducto = tiposProducto;
        this.maxTiempoProduccionMs = maxTiempoProduccionMs;
    }

    @Override
    public void run() {
        for (int i = 1; i <= cantidadAProducir; i++) {
            try {
                // Simular tiempo de producción aleatorio
                int tiempo = random.nextInt(maxTiempoProduccionMs) + 1;
                Thread.sleep(tiempo);

                String tipo = tiposProducto[random.nextInt(tiposProducto.length)];
                Product product = new Product(i, tipo, getName());

                almacen.put(product);

            } catch (InterruptedException e) {
                System.out.printf("Productor %s interrumpido.%n", getName());
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.printf("Productor %s ha terminado de producir.%n", getName());
    }
}

