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


	public Companyia buscarPorNombre(String nombre) {

		Companyia result = new Companyia();

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			s.beginTransaction();

			String hql = "SELECT c FROM Companyia c WHERE c.nombre=:nom";
			Query q = s.createQuery(hql);
			q.setParameter("nom", nombre);
			result = (Companyia) q.uniqueResult();
			s.getTransaction().commit();

		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return result;
	}
}