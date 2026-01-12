package interfaz;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DAO.DaoCompanyia;
import Pojos.Companyia;
import Pojos.Disco;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;
public class HQL_EjD {

	public static void main(String[]args){
		
		SessionFactory s = UtilesHibernate.getSessionFactory();
	
		try {
			SessionFactory factory = UtilesHibernate.getSessionFactory();
			
			Session sesion = factory.getCurrentSession();
			
			sesion.beginTransaction();
			
			
			List<Companyia> listac = new ArrayList<Companyia>();
			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			listac = daoCompanyia.buscarTodos();
			for (Companyia c : listac) {
				System.out.println(c.getNombre() + "-" + c.getTfno());
			}
			
			sesion.getTransaction().commit();
			sesion.close();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
		
		
	}
}
