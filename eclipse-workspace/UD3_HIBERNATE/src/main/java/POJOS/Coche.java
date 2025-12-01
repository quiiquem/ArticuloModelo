package POJOS;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Coche")
public class Coche implements Serializable{
	private static final long serialVersionUID = 1L;
	private String matricula;
	private String nomequipo;
	private int km;
	private String patrocinador;
	private String marca;
	private String funcion;
	private String tipo;

	//--Clave ajena
	
	
		//Clave ajena con equipo
			@OneToOne(fetch=FetchType.LAZY) 
			@JoinColumn(name= "nomeq") 
			private Equipo equipo;
}