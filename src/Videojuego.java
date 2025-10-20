public class Videojuego {
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private int anio;
    private int valoracion;

    /**
     * Constructor para cada objeto Videojuego
     * @param titulo String que representa el nombre del videojuego
     * @param genero String que representa al genero
     * @param plataforma String que representa el dispositivo donde corre el juego
     * @param anio int que representa el año de salida
     * @param valoracion int entre 1 y 10
     */
    public Videojuego(String titulo, String genero, String plataforma, int anio, int valoracion) {
        this.id++; // Antonio: El Id en la base de datos es autoincremental
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        this.valoracion = valoracion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getAnio() {
        return anio;
    }

    public int getValoracion() {
        return valoracion;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", anio=" + anio +
                ", valoracion=" + valoracion +
                '}';
    }
}
