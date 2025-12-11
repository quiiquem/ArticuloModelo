package POJOS;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="ciclista")
public class Ciclista implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dorsal;
	private String nombre;
	private Date nacimiento;

	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY )
	@JoinColumn(name="nomeq")
	private Equipo equipo;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="ciclista")
	List<Etapa>etapas=new ArrayList<Etapa>();
	
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="ciclistas")
	List<Premio>premios=new ArrayList<Premio>();
	

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="ciclista")
	List<Puerto>puertos=new ArrayList<Puerto>();

	public Ciclista() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Ciclista(Integer dorsal, String nombre, Date nacimiento, Equipo equipo, List<Etapa> etapas,
			List<Premio> premios, List<Puerto> puertos) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.equipo = equipo;
		this.etapas = etapas;
		this.premios = premios;
		this.puertos = puertos;
	}













	public List<Puerto> getPuertos() {
		return puertos;
	}













	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}













	public List<Premio> getPremios() {
		return premios;
	}



	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}



	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}

	public Integer getDorsal() {
		return dorsal;
	}
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	/*public List<Premio> getPremios() {
		return premios;
	}

	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}*/

	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dorsal == null) ? 0 : dorsal.hashCode());
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((nacimiento == null) ? 0 : nacimiento.hashCode());
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
		Ciclista other = (Ciclista) obj;
		
		if (dorsal == null) {
			if (other.dorsal != null)
				return false;
		} else if (!dorsal.equals(other.dorsal))
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (nacimiento == null) {
			if (other.nacimiento != null)
				return false;
		} else if (!nacimiento.equals(other.nacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Ciclista [dorsal=" + dorsal + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", equipo=" + equipo
				+ ", etapas=" + etapas + ", premios=" + premios + ", puertos=" + puertos + "]";
	}
	

}
