package POJOS;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="premios")
public class Premio implements Serializable{

	private Integer codigo;
	private String descripcion;
	private Integer cantidad;
	private String premioscol;
	private String premioscol1;
	

@ManyToMany //ManyToMany tiene una forma diferente de enlazar en hibernate
	
	@JoinTable(name="gana", //Hacemos join table a Gana
	joinColumns= {@JoinColumn(name="premio",referencedColumnName="codigo")}, //Hace join a columna premios con referencia a codigo
	inverseJoinColumns= {@JoinColumn(name="dorsal", referencedColumnName="dorsal")}) //Hace join a columna ciclista a la tabla dorsal
	
private List<Ciclista>ciclistas = new ArrayList<Ciclista>();
}
