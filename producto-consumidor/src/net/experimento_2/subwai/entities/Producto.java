package net.experimento_2.subwai.entities;

class Producto {
    private final int id;
    private final String tipo;
    private final String productor;

    public Producto(int id, String tipo, String productor) {
        this.id = id;
        this.tipo = tipo;
        this.productor = productor;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getProductor() {
        return productor;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", productor='" + productor + '\'' +
                '}';
    }
}