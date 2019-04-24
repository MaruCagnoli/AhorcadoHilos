package UTNteam;


import UTNteam.Clases.Ahorcado;
import UTNteam.Clases.Jugador;

public class App {
    public static void main(String[] args) {

        Ahorcado jugada1 = new Ahorcado();
        Thread jugador1 = new Thread(new Jugador(jugada1, "Karina"));
        Thread jugador2 = new Thread(new Jugador(jugada1, "Matias"));

        jugador1.start();
        jugador2.start();

    }
}
