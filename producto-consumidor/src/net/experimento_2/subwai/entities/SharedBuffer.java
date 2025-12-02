package net.experimento_2.subwai.entities;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Product> buffer = new LinkedList<>();
    private final int capacidad;

    public SharedBuffer(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void put(Product product) throws InterruptedException {
        while (buffer.size() == capacidad) {
            System.out.printf("[ALMACÉN LLENO] Productor %s espera.%n",
                    Thread.currentThread().getName());
            wait();
        }

        buffer.add(product);
        System.out.printf("[PRODUCIDO] %s ha producido %s. Ocupación: %d/%d%n",
                product.getProductor(), product, buffer.size(), capacidad);

        // Notificamos a posibles consumidores en espera
        notifyAll();
    }

    public synchronized Product take() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.printf("[ALMACÉN VACÍO] Consumidor %s espera.%n",
                    Thread.currentThread().getName());
            wait();
        }

        Product product = buffer.remove();
        System.out.printf("[CONSUMIDO] Consumidor %s va a consumir %s. Ocupación: %d/%d%n",
                Thread.currentThread().getName(), product, buffer.size(), capacidad);

        // Notificamos a posibles productores en espera
        notifyAll();
        return product;
    }

}
