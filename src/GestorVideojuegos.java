import java.util.ArrayList;
import java.util.List;

public class GestorVideojuegos {
    List<Videojuego> lista;

    /**
     *
     */
    public GestorVideojuegos() {
        this.lista = new ArrayList<>();
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
        Videojuego juego = new Videojuego(titulo, genero, plataforma, anio, valoracion);
        if(!lista.contains(juego)){
            return lista.add(juego);
        }else{
            return false;
        }
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
    public Videojuego[] bestScore(int count){
//        Implementacion
    }
}