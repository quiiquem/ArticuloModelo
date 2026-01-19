package DAO;

import hibernate.UtilesHibernate;
import Pojos.Disco;
import dao.DaoGenericoHibernate;
import excepciones.BusinessException;

import java.util.ArrayList;
import java.util.List;

import Pojos.Cancion;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

public class DaoDisco 
	extends DaoGenericoHibernate<Disco, Integer>{
		private final static Logger
		LOGGER=Logger.getLogger(DaoDisco.class.getName());
		
		
		
		//Listar todas las cnaciones
		public List<Cancion> listarCancionesPorNombreDisco(String nombreDisco) throws BusinessException {
		    Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		    List<Cancion> result = null;

		    try {
		        s.beginTransaction();

		        String hql = "SELECT c FROM Disco d JOIN d.cancions c WHERE d.nombre = :nom";
		        Query<Cancion> q = s.createQuery(hql, Cancion.class);
		        q.setParameter("nom", nombreDisco);

		        result = q.list();

		        s.getTransaction().commit();

		    } catch (Exception e) {
		        if (s.getTransaction().isActive()) {
		            s.getTransaction().rollback();
		        }
		        throw new BusinessException("Error al listar canciones del disco");
		    }

		    return result;
		}


		
		
		
		//Metodo que suma las duraciones
		public Long Sumar_duracion(String nombreDisco) {
		Long duracion = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			s.beginTransaction();
			String hql ="select sum(d.c.duracion) from"
					+ "Disco d join d.canciones c where"
					+ "d.nombre=:nombreDisco";
			Query q = s.createQuery(hql);
			q.setParameter("nombreDisco", nombreDisco);
			duracion = (Long) q.uniqueResult();
			s.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return duracion;
		}
		
}
