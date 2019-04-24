package UTNteam.Clases;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Ahorcado {

    private Dao daoJuego;
    private List<Character> abecedario;
    private String palabraJuego;
    private int idPalabraJuego;
    static private boolean juegoOcupado = Boolean.FALSE;
    static private boolean hayGanador = Boolean.FALSE;



    public Ahorcado(){

        this.daoJuego = new Dao();
        this.daoJuego.conectar();
        this.abecedario = new ArrayList<>();
        this.abecedario = generarTablaLetras();
        Palabra palabra = daoJuego.traerPalabra();
        this.palabraJuego = palabra.getPalabra();
        this.idPalabraJuego = palabra.getId();


    }
    public String getPalabraJuego(){
        return this.palabraJuego;
    }
    public int getIdPalabraJuego(){return this.idPalabraJuego;}
    public void setPalabraJuego(String palabra){
        this.palabraJuego = palabra;
    }
    public ArrayList<Character> generarTablaLetras(){
        String letras = "abcdefghijklmnñopqrstuvwxyz";
        ArrayList<Character> abc = new ArrayList<>();

        for(int i = 0; i< letras.length(); i++){
            abc.add(letras.charAt(i));
        }
        return abc;
    }


    public synchronized int jugarAhorcado(){


        while(Boolean.TRUE.equals(juegoOcupado)){
            try{
                wait();

            }catch(InterruptedException e){
                e.getMessage();
            }
        }
        juegoOcupado = Boolean.TRUE;
        int acertoLetra=1;
        if(hayGanador == Boolean.FALSE) {


            while (!palabraJuego.isEmpty() && acertoLetra == 1) {
                int indice = (int) (Math.random() * (this.abecedario.size() - 0) + 0);

                String letra = String.valueOf(this.abecedario.get(indice));

                if (palabraJuego.contains(letra)) {
                    while (palabraJuego.contains(letra)) {
                        palabraJuego = palabraJuego.replace(String.valueOf(this.abecedario.get(indice)), "");
                        this.abecedario.remove(this.abecedario.get(indice));
                        System.out.println(palabraJuego);
                        System.out.println(this.abecedario);
                        acertoLetra = 1;
                    }

                    if (palabraJuego.isEmpty()) {
                        acertoLetra = 2;

                        hayGanador = Boolean.TRUE;
                    }

                    System.out.println(palabraJuego);
                    System.out.println(this.abecedario);

                } else {
                    acertoLetra = 0;
                }

            }

            this.juegoOcupado = Boolean.FALSE;
            notify();

        }else {

            acertoLetra = 3;

        }

        return acertoLetra;



    }
}
