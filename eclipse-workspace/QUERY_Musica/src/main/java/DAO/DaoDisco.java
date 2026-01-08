package DAO;

import hibernate.UtilesHibernate;
import Pojos.Disco;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

public class DaoDisco 
	extends DaoGenericoHibernate<Disco, Integer>{
		final Logger
		LOGGER=Logger.getLogger(DaoDisco.class.getName());
		
public Disco buscarPorNombre(String nombre) {
		Disco result = new Disco();

		// Iniciar session de hibernate
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			s.beginTransaction();

			String hql = "SELECT a FROM Artista a WHERE a.nombre=:nom"; // Cadena SQL
			Query q = s.createQuery(hql); // Inicio de query
			q.setParameter("nom", nombre);
			result = (Disco) q.uniqueResult(); //Resultado: Un Query con resultado unico
			s.getTransaction().commit(); //Comete los cambios en la BD
			
			//Exceptiones
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return result; //Que lo devuelva
	}


public ArrayList<Disco> listarDiscos(ArrayList<Disco> discos) {
	ArrayList<Disco> result = new ArrayList<Disco>();
	
	// Iniciar session de hibernate
			Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
	return result;
}
}
