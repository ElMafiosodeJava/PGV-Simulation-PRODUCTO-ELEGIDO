package net.experimento_2.subwai.entities;

import java.util.LinkedList;
import java.util.Queue;

public class Almacen {
    private final Queue<Producto> buffer = new LinkedList<>();
    private final int capacidad;

    public Almacen(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void put(Producto product) throws InterruptedException {
        while (buffer.size() == capacidad) {
            System.out.printf("[ALMACÉN LLENO] Productor %s espera.%n",
                    Thread.currentThread().getName());
            wait();
        }

        buffer.add(product);
        System.out.printf("[PRODUCIDO] %s ha producido %s. Ocupación: %d/%d%n",
                product.getProductor(), product, buffer.size(), capacidad);

        notifyAll();
    }

    public synchronized Producto take() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.printf("[ALMACÉN VACÍO] Consumidor %s espera.%n",
                    Thread.currentThread().getName());
            wait();
        }

        Producto product = buffer.remove();
        System.out.printf("[CONSUMIDO] Consumidor %s va a consumir %s. Ocupación: %d/%d%n",
                Thread.currentThread().getName(), product, buffer.size(), capacidad);

        notifyAll();
        return product;
    }

}
