import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GestorVideojuegos {
    List<Videojuego> lista;
    Connection conexion;

    /**
     * Constructor de GestorVideojuegos.
     * Inicializa la lista interna y establece la conexión con la base de datos.
     */
    public GestorVideojuegos() {
        this.lista = new ArrayList<>();
        // Creamos la conexión real con la bbdd
        this.conexion = ConexionDB.getConnection();
    }


    /**
     * Añade un nuevo videojuego.
     * La línea pstmt.executeUpdate() está comentada, por lo que este
     * método actualmente NO inserta en la BBDD, solo en la lista local en memoria.
     *
     * @param titulo     Título del videojuego.
     * @param genero     Género del videojuego.
     * @param plataforma Plataforma (ej. PC, PS5).
     * @param anio       Año de lanzamiento.
     * @param valoracion Valoración del 1 al 10.
     * @return true si se añade a la lista local, false si ya existía en la lista.
     * @throws SQLException Si ocurre un error al preparar la consulta (aunque no se ejecute).
     */
    public boolean addGame(String titulo, String genero, String plataforma, int anio, int valoracion) throws SQLException {
        int filasAfectadas = 0;
        // Preparamos el insert into con un preparedStatement
        try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO videojuegos(titulo, genero, plataforma, anio, valoracion) VALUES(?,?,?,?,?)")) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, genero);
            pstmt.setString(3, plataforma);
            pstmt.setInt(4, anio);
            pstmt.setInt(5, valoracion);
            // TODO: filasAfectadas = pstmt.executeUpdate();
        }
        // TODO: añadir videojuego a la base de datos y a la memoria (ArrayList)
        // Videojuego juego = new Videojuego(titulo, genero, plataforma, anio, valoracion);
        // if (!lista.contains(juego)) {
        // return lista.add(juego);
        // } else {
        // return false;
        // }
        return true; // Debe de devolver true si se inserta bien en la base de datos y se actualiza en memoria
    }

    /**
     * Elimina un videojuego de la BBDD y de la lista local usando su ID.
     * (Método pendiente de implementación).
     *
     * @param id ID del videojuego a eliminar.
     */
    public void removeGame(int id) {
//        Implementacion
    }

    /**
     * Busca videojuegos según un criterio.
     * (Método pendiente de implementación).
     *
     * @param campoBuscar Criterio de búsqueda [1: Titulo, 2: Plataforma, 3: Genero].
     * @param valor       Valor a buscar en el campo seleccionado.
     */
    public void search(int campoBuscar, String valor) {
//        Implementacion
    }

    /**
     * Obtiene (o actualiza) la lista completa de videojuegos desde la BBDD.
     * (Método pendiente de implementación).
     */
    public void getLista() {
//        Implementacion
    }

    /**
     * Obtiene los 'count' videojuegos con mejor valoración desde la base de datos.
     *
     * @param count El número máximo de videojuegos a devolver.
     * @return Un array de objetos Videojuego (Videojuego[]) ordenados por valoración descendente.
     * @throws SQLException Si ocurre un error de acceso a la base de datos.
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

                listaVideojuegos.add(new Videojuego(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        }
        return listaVideojuegos.toArray(new Videojuego[0]);
    }
}