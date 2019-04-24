package UTNteam.Clases;


import java.sql.*;
import java.util.Date;

public class Dao {

    static final String DB_URL = "jdbc:mysql://localhost:3306/ahoracado_db";
    static final String USER = "root";
    static final String PASSWORD = "root";
    Connection conexion = null;

    public void conectar() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            this.conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se puede abrir la base de datos");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Palabra traerPalabra() {

        Palabra pal = new Palabra();
        try {
            String query = "SELECT id_palabra, palabra FROM palabras order by rand() limit 1";
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);


            if (rs.next()) {
                pal.setId(rs.getInt("id_palabra"));
                pal.setPalabra(rs.getString("palabra"));


            }
        } catch (SQLException e) {

            System.out.println("Revise conexion, no se puede traer palabra. ");
        }
        return pal;
    }

    void insertarGanador(String nombre, int id_palabra, Date fecha) {

        try {
            String sql = "INSERT INTO ganadores (nombre_ganador, id_palabra, fecha) values (?,?,now())";
            PreparedStatement prepare = conexion.prepareStatement(sql);
            prepare.setString(1, nombre);
            prepare.setInt(2, id_palabra);

            prepare.execute();
        } catch (SQLException e) {
            System.out.println("Veniamos bien, pasaron cosas");
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("El sistema habría colapsado.");
                e.printStackTrace();
            }
        }
    }




}
