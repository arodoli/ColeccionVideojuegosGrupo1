import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorVideojuegos videojuegos = new GestorVideojuegos();
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n=== MENÚ COLECCIÓN DE VIDEOJUEGOS ===");
            System.out.println("1. Añadir un nuevo juego");
            System.out.println("2. Eliminar un juego");
            System.out.println("3. Buscar juegos");
            System.out.println("4. Mostrar todos los juegos");
            System.out.println("5. Mostrar los juegos mejor valorados");
            System.out.println("6. Salir");
            System.out.println("Elige una opción.");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida, inténtalo de nuevo.");
                continue;
            }

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.println("INGRESA UN JUEGO:\n");
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Género: ");
                        String genero = sc.nextLine();
                        System.out.print("Plataforma: ");
                        String plataforma = sc.nextLine();
                        System.out.print("Año: ");
                        int anno = sc.nextInt();
                        System.out.print("Valoración (1-10): ");
                        int valoracion = sc.nextInt();
                        sc.nextLine();//videojuegos.addGame(titulo, genero, plataforma, anno, valoracion)
                        System.out.println("Juego añadido satisfactoriamente.");

                    }
                    case 2 -> {
                        System.out.println("ELIMINA UN JUEGO:\n");
                        System.out.print("ID a eliminar: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        // insertar respectivo método
                    }
                    case 3 -> {
                        System.out.println("BUSCA UN JUEGO:\n");
                        System.out.println("Busca por titulo:");
                        String texto = sc.nextLine();
                        // insertar respectivo método
                    }
                    case 4 -> {
                        System.out.println("LISTA DE TODOS LOS JUEGOS:\n");
                        // insertar respectivo método
                    }
                    case 5 -> {
                        System.out.println("LISTA DE LOS JUEGOS MEJOR VALORADOS:\n");
                        // insertar respectivo método
                    }
                    case 6 -> {
                        System.out.println("Saliendo...");
                    }
                    default -> {
                        System.out.println("Opción no válida, elige entre 1 y 6.");
                    }
                }
            }  catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}