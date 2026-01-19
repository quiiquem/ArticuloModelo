package interfaz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import DAO.DaoDisco;
import Pojos.Cancion;
import Pojos.Disco;
import hibernate.UtilesHibernate;

public class HQL_EjI {


    public static void main(String[] args) {

        try {
            DaoDisco daoDisco = new DaoDisco();

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre del disco:");
            String nombreDisco = sc.nextLine();

            // Llamada al DAO
            List<Cancion> canciones = daoDisco.listarCancionesPorNombreDisco(nombreDisco);

            if (canciones == null || canciones.isEmpty()) {
                System.out.println("No se encontraron canciones para ese disco.");
            } else {
                System.out.println("Canciones del disco '" + nombreDisco + "':");

                for (Cancion c : canciones) {
                    System.out.println("- " + c.getTitulo());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
