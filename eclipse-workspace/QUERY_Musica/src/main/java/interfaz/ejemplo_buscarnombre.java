package interfaz;

import hibernate.UtilesHibernate;

import java.util.Scanner;

import DAO.DaoArtista;
import Pojos.Artista;
public class ejemplo_buscarnombre {

	public static void main(String[]args) {
		
		Artista a=new Artista();
		
		try {
			//Abrir sesion de hibernate
			UtilesHibernate.openSession();
			DaoArtista daoArtista=new DaoArtista();
			
			//Leer datos en interfaz
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el nombre del Artista");
			String nombre = sc.nextLine();
			
			//BUSCAR EN LA BD
			a=daoArtista.buscarPorNombre(nombre);
			
			//Mostrar resultado
			System.out.println(a.getNombre());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Cerrar hibernate
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
