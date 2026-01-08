package DAO;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import Pojos.Artista;
import hibernate.UtilesHibernate;

public class DaoArtista extends DaoGenericoHibernate<Artista, String> { // Hacer que funcione
	private final static Logger LOGGER = Logger.getLogger(DaoCancion.class.getName());

	// Buscar un artista por nombre
	public Artista buscarPorNombre(String nombre) {
	
		Artista result = new Artista(); //Objeto artista

		// Iniciar session de hibernate
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			s.beginTransaction();

			String hql = "SELECT a FROM Artista a WHERE a.nombre=:nom"; // Cadena SQL
			Query q = s.createQuery(hql); // Inicio de query
			q.setParameter("nom", nombre); // Poner el parametro
			result = (Artista) q.uniqueResult(); //Resultado: Un Query con resultado unico
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
}
