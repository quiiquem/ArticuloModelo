package interfaz;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Pojos.Companyia;
import excepciones.BusinessException;
import DAO.DaoCompanyia;
import hibernate.UtilesHibernate;

public class HQL_EjF {

	public static void main(String[] args) throws BusinessException {

		Scanner sc = new Scanner(System.in);

		Companyia companyia = new Companyia();

		UtilesHibernate.openSession();
		System.out.println("Inserta el nombre de la compañía:");
		String nombre = sc.nextLine();
		DaoCompanyia daoCompanyia = new DaoCompanyia();
		companyia = daoCompanyia.buscarPorNombre(nombre);

		if (companyia == null) {
			System.out.println("No se ha encontrado la compañía");
		}

		else {
			System.out.println("Compañía encontrada: " + companyia.getNombre() + " - " + companyia.getTfno() + " - "
					+ companyia.getFax());

		}

		sc.close();
	}
}
