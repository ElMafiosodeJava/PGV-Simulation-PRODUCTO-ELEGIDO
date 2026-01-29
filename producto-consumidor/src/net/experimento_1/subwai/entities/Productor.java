package net.experimento_1.subwai.entities;

import java.util.Random;

public class Productor extends Thread{
    private final Almacen almacen;
    private final int cantidadAProducir;
    private final String[] tiposProducto;
    private final int tiempoProduccionMax;
    private final Random random = new Random();

    public Productor(String nombre, Almacen almacen, int cantidadAProducir,
                    String[] tiposProducto, int maxTiempoProduccionMs) {
        super(nombre);
        this.almacen = almacen;
        this.cantidadAProducir = cantidadAProducir;
        this.tiposProducto = tiposProducto;
        this.tiempoProduccionMax = maxTiempoProduccionMs;
    }

    @Override
    public void run() {
        for (int i = 1; i <= cantidadAProducir; i++) {
            try {
                int tiempo = random.nextInt(tiempoProduccionMax) + 1;
                Thread.sleep(tiempo);

                String tipo = tiposProducto[random.nextInt(tiposProducto.length)];
                Producto product = new Producto(i, tipo, getName());

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

