package POJOS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="equipo")
public class Equipo implements Serializable {
	@Id
	@Column(name="nomeq")
	private String nombre;
	private String director;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="equipo")
	private List<Ciclista>ciclistas= new ArrayList<Ciclista>();
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="equipo")
	private Coche coche;
			
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="equipo")
	private Representante representante;
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Coche getCoche() {
		return coche;
	}


	public void setCoche(Coche coche) {
		this.coche = coche;
	}


	public Representante getRepresentante() {
		return representante;
	}


	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}


	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}


	public Equipo(String nombre, String director, List<Ciclista> ciclistas) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.ciclistas = ciclistas;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}
	public void setCiclistas(ArrayList<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclistas == null) ? 0 : ciclistas.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (ciclistas == null) {
			if (other.ciclistas != null)
				return false;
		} else if (!ciclistas.equals(other.ciclistas))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
}
