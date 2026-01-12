package DAO;

import hibernate.UtilesHibernate;
import Pojos.Disco;
import dao.DaoGenericoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

public class DaoDisco 
	extends DaoGenericoHibernate<Disco, Integer>{
		private final static Logger
		LOGGER=Logger.getLogger(DaoDisco.class.getName());
		
}
