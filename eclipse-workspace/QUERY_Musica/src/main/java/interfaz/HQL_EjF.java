package interfaz;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Pojos.Companyia;
import DAO.DaoCompanyia;
import hibernate.UtilesHibernate;

public class HQL_EjF {

public static void main(String []args){
	
	SessionFactory s = UtilesHibernate.getSessionFactory();

	try {
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		
		Session sesion = factory.getCurrentSession();
		
		sesion.beginTransaction();
		
		DaoCompanyia daoCompanyia = new DaoCompanyia();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta el nombre de la compañia");
		String nom = sc.nextLine();
		
		List<Companyia> lista = daoCompanyia.Listar_Tel_Fax(nom);
		for(Companyia a : lista) {
			System.out.println("Telefono: "+" FAX: ");
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
