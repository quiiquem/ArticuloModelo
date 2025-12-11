package Ejemplos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import POJOS.Equipo;
import POJOS.Etapa;
import POJOS.Puerto;
import hibernate.UtilesHibernate;

public class Eliminar_DAM55_Ej1 {

	public static void main(String[] args) {
	
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		
		Session sesion = factory.getCurrentSession();
		sesion.beginTransaction();
		
		Equipo DAM55 = new Equipo("DAM55", null, null);
		sesion.save(DAM55);
		
		//sesion.delete(DAM55);
		
		sesion.getTransaction().commit();
		factory.close();
		
	}

}