package interfaz;

import java.util.ArrayList;
import java.util.List;

import DAO.DaoDisco;
import Pojos.Disco;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;

public class ejemplo_listardiscos {

	public static void main(String[] args) {

		DaoDisco daoDisco = new DaoDisco();

		List<Disco> ldiscos = new ArrayList<Disco>();
		// BUSCAR EN LA BD
		try {
			UtilesHibernate.openSession();

			ldiscos = daoDisco.buscarTodos();
			for (Disco d : ldiscos) {
				System.out.println(d.getNombre() + "-" + d.getCompanyia().getNombre());
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerrar hibernate
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}
}
