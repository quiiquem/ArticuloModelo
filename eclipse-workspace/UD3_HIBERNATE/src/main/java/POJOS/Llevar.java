package POJOS;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="llevar")
public class Llevar implements Serializable {

	//Propiedades tabla
	@Column(name="llevar")
	private String codigo;
	private int netapa;
	private int dorsal;
	
	//--Claves ajenas
	
	
	//Clave ajena con ciclista
		@ManyToOne(fetch=FetchType.LAZY) 
		@JoinColumn(name= "dorsal") 
		private Ciclista ciclista;
		
		//Clave ajena con etapa
		@ManyToOne(fetch=FetchType.LAZY) 
		@JoinColumn(name= "netapa") 
		private Etapa etapa;
		
		//Clave ajena con maillot
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="codigo")
		private Maillot maillot;
	
}
