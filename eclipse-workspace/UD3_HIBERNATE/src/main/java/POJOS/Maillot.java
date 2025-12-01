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
@Table(name="maillot")
public class Maillot implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "maillot")
	private Maillot Maillot;
	private String codigo;
	private String tipo;
	private String color;
	private int premio;

	
	//Clave ajena con llevar
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="codigo")
	private Llevar llevar;
	
	
	
}
