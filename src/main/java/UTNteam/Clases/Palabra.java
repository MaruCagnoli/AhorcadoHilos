package UTNteam.Clases;

public class Palabra {

    private String palabra;
    private int id;

    public Palabra(){}
    public Palabra(int id, String p){

        this.id = id;
        this.palabra = p;


    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "palabra='" + palabra + '\'' +
                ", id=" + id +
                '}';
    }
}
