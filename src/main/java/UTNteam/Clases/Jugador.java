package UTNteam.Clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jugador implements Runnable {

    private Ahorcado ahorcado;
    private String nombre;
    private Dao daoAhorcado;
    private Date fecha;
    private int vidas;



    public Jugador(Ahorcado juego, String nombre){

        this.ahorcado = juego;
        this.nombre = nombre;
        this.daoAhorcado = new Dao();
        this.daoAhorcado.conectar();
        this.fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(this.fecha);
        this.vidas = 20;


    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public Date getFecha(){
        return this.fecha;
    }


    @Override
    public void run() {

        int result=0;
        while (this.vidas > 0 && result != 2) {
            result = ahorcado.jugarAhorcado();

            if (result == 0) {
                this.vidas = this.vidas - 1;
            } else if (result == 2) {

                System.out.println("Tenemos un ganador!!!");
                System.out.println(this.nombre);
                daoAhorcado.insertarGanador(this.nombre, ahorcado.getIdPalabraJuego(), fecha);
                Thread.currentThread().interrupt();


            } else if (result == 3) {
                //Thread.currentThread().stop();
                this.vidas = this.vidas - this.vidas;
                Thread.currentThread().interrupt();


            }


        }




    }
}
