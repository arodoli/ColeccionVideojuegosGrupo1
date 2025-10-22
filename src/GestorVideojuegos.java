import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestorVideojuegos {
    List<Videojuego> lista;
    Connection conexion;

    /**
     *
     */
    public GestorVideojuegos() {
        this.lista = new ArrayList<>();
        // Creamos la conexión real con la bbdd
        this.conexion = ConexionDB.getConnection();
    }


    /**
     *
     * @param titulo String
     * @param genero String
     * @param plataforma String
     * @param anio int
     * @param valoracion int (1-10)
     * @return boolean
     */
    public boolean addGame(String titulo, String genero, String plataforma, int anio, int valoracion) {
//        Implementacion
    }

    /**
     *
     * @param id juego a eliminar
     * @return boolean
     */
    public boolean removeGame(int id){
//        Implementacion
    }

    /**
     *
     * @param campoBuscar [1: Titulo, 2: Plataforma, 3: Genero]
     * @param valor: valor por el que buscamos
     * @return List[] de juegos
     */
    public Videojuego[] search(int campoBuscar, String valor) {
//        Implementacion
    }

    /**
     *
     * @return List[] de juegos
     */
    public Videojuego[] getLista() {
//        Implementacion
    }

    /**
     *
     * @param count maximo de juegos que se van a mostrar
     * @return List[] de juegos
     */
    public Videojuego[] bestScore(int count) throws SQLException {
        // Creamos una lista de videojuegos
        List<Videojuego> listaVideojuegos = new ArrayList<>();
        // Preparamos la plantila SQL
        String sql = "SELECT * FROM videojuegos v ORDER BY v.valoracion DESC LIMIT ?;";
        // Creamos el PreparedStatement
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            // Pasamos el parámetro
            ps.setInt(1, count);
            // Ejecutamos la consulta
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaVideojuegos.add(new Videojuego(rs.getInt(1)))
            }
        }
    }
}