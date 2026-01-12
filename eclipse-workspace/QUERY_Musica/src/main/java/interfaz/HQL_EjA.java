package interfaz;

import Pojos.Companyia;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DAO.DaoCompanyia;
import hibernate.UtilesHibernate;

public class HQL_EjA{

public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
	
	try {
		
		
	//TODO
	
		//Pedir datos
		System.out.println("Inserta el nombre de la compañia");
		
		String nom = sc.nextLine();
		
		System.out.println("Inserta la dirección de la compañia");
		
		String dir = sc.nextLine();
		
		System.out.println("Inserta el FAX");
		
		String fax = sc.nextLine();
		
		System.out.println("Inserta el telefono");
		
		String num = sc.nextLine();
		Companyia c = new Companyia(nom,dir,fax,num,null); //Hacer compañia
		
		DaoCompanyia daoCompanyia = new DaoCompanyia();
		
		//Guardar compañia
		daoCompanyia.grabar(c);
	
		
	} catch (Exception e){
		
		e.printStackTrace();
		
	} 
}
}