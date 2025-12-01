package POJOS;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Premios")
public class Premio implements Serializable{

	private int codigo;
	private String descripcion;
	private int cantidad;
	private String premioscol;
	private String premioscol1;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="premio")
	private Gana gana;
	
	
}
