package Interfaz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import POJOS.Etapa;
import POJOS.Puerto;
import hibernate.UtilesHibernate;

public class Insertar_Puerto {

	public static void main (String[]args) {
		Etapa e = new Etapa();
		SessionFactory factory = UtilesHibernate.getSessionFactory(); //inicia el objeto de generar sesiones para conectar y trabajar con la BD hibernate
		Session sesion=factory.getCurrentSession();
		
		//Iniciar transacción objetos persistente
		sesion.beginTransaction(); //a partir de ahora si afecta a la BD
		
		//Buscar la etapa 9
		e=sesion.get(Etapa.class, 9);
		Puerto pu=new Puerto("PenyaGolosa",434,"E",21.3,e,null); //objeto con todas las tablas
		
	
		
	}
}
