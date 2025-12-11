package Interfaz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;

public class Cambiar_Datos_Ej {
	public static void main(String[]args) {
		
		SessionFactory factory = UtilesHibernate.getSessionFactory(); //declarar sesion (conexion con MySql)
		
		Session sesion = factory.getCurrentSession(); //pillar sesion
		
		sesion.beginTransaction(); //iniciar transacción (que ahora lo que hagamos afecta a la BD)
		
		
	}

}
