package subwai.threads;

public class Productor extends Thread{
    private String threadName = "subwai";
    private int cantidadTotalBocadillos;
    private int[] bocadillo = new int[10];
    private int tiempoMaximoFabricación;
    

    public Productor(String id, int cantidadTotalBocadillos, int[] bocadillo, int tiempoMaximoFabricación,
            Tienda tienda, String threadName) {
        setName(threadName);
        this.cantidadTotalBocadillos = cantidadTotalBocadillos;
        this.bocadillo = bocadillo;
        this.tiempoMaximoFabricación = tiempoMaximoFabricación;
        this.tienda = tienda;
    }


    public int getCantidadTotalBocadillos() {
        return cantidadTotalBocadillos;
    }


    public void setCantidadTotalBocadillos(int cantidadTotalBocadillos) {
        this.cantidadTotalBocadillos = cantidadTotalBocadillos;
    }


    public int[] getBocadillo() {
        return bocadillo;
    }


    public void setBocadillo(int[] bocadillo) {
        this.bocadillo = bocadillo;
    }


    public int getTiempoMaximoFabricación() {
        return tiempoMaximoFabricación;
    }


    public void setTiempoMaximoFabricación(int tiempoMaximoFabricación) {
        this.tiempoMaximoFabricación = tiempoMaximoFabricación;
    }


    public Tienda getTienda() {
        return tienda;
    }


    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }



    Tienda tienda = new Tienda();


    @Override
    public void run() {

    }




}
