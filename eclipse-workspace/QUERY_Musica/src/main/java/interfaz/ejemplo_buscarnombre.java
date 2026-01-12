package interfaz;

import hibernate.UtilesHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.DaoArtista;
import DAO.DaoDisco;
import Pojos.Artista;
import Pojos.Disco;
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
			
			
			a=daoArtista.buscarPorNombre(nombre);
			
			//Mostrar resultado
			System.out.println(a.getNombre());
			
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Cerrar hibernate
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
			
		}
	}
}
