package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import Pojos.Artista;
import Pojos.Companyia;
import dao.DaoGenericoHibernate;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;


public class DaoCompanyia extends DaoGenericoHibernate<Companyia, Integer> {
	private final static Logger LOGGER = Logger.getLogger(DaoDisco.class.getName());


	public List<Companyia> Listar_Tel_Fax(String nombre) throws BusinessException{
		List<Companyia> result = new ArrayList<Companyia>();

		// Iniciar session de hibernate
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
	
		try {
			s.beginTransaction();

			String hql = "SELECT tfno,fax FROM Companyia c WHERE c.nombre=:nom"; // Cadena SQL
			Query q = s.createQuery(hql); // Inicio de query
			q.setParameter("nom", nombre); // Poner el parametro
			result = (List<Companyia>) q.uniqueResult(); //Resultado: Un Query con resultado unico
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