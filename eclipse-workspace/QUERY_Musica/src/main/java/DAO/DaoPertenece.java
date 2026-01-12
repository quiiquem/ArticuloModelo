package DAO;
import Pojos.Artista;
import Pojos.Pertenece;
import Pojos.PerteneceId;
import dao.DaoGenericoHibernate;

import java.util.logging.Logger;

public class DaoPertenece 
	extends DaoGenericoHibernate<Pertenece, PerteneceId>{
	private final static Logger
	LOGGER=Logger.getLogger(DaoPertenece.class.getName());
	
	public Pertenece buscarPorNombre(String nombre) {
		return null;
		
	}
}
