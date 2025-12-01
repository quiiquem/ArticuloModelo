package POJOS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="equipo")
public class Equipo implements Serializable{

	@Override
	public int hashCode() {
		return Objects.hash(ciclistas, director, nombre);
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
		return Objects.equals(ciclistas, other.ciclistas) && Objects.equals(director, other.director)
				&& Objects.equals(nombre, other.nombre);
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

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}

	
	@Id 
	@Column(name="nomeq") //nombre de la columna principal (PK) 
	private String nombre;
	private String director;
	
	//Unirlo a ciclista
	@OneToMany(mappedBy="equipo", fetch=FetchType.LAZY) //dependiendo de la BD renta mas eager o lazy, cuidao 
	private List<Ciclista> ciclistas = new ArrayList<Ciclista>(); //lista de los ciclistas para mostrar todo
	
	
	//TODO: Unirlo a representante
}

