package POJOS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;



@Entity
@Table(name="coche")
public class Coche implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod;
	private String matricula;
	private String patrocinador;
	private Integer km;
	private String marca;
	private String funcion;
	private String tipo;




	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="nomequipo")
	private Equipo equipo;


	public Coche(Integer cod, String matricula, String patrocinador, Integer km, String marca, String funcion,
			String tipo, Equipo equipo) {
		super();
		this.cod = cod;
		this.matricula = matricula;
		this.patrocinador = patrocinador;
		this.km = km;
		this.marca = marca;
		this.funcion = funcion;
		this.tipo = tipo;
		this.equipo = equipo;
	}


	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCod() {
		return cod;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getPatrocinador() {
		return patrocinador;
	}


	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}


	public Integer getKm() {
		return km;
	}


	public void setKm(Integer km) {
		this.km = km;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getFuncion() {
		return funcion;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


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
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((funcion == null) ? 0 : funcion.hashCode());
		result = prime * result + ((km == null) ? 0 : km.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((patrocinador == null) ? 0 : patrocinador.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Coche))
			return false;
		Coche other = (Coche) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (funcion == null) {
			if (other.funcion != null)
				return false;
		} else if (!funcion.equals(other.funcion))
			return false;
		if (km == null) {
			if (other.km != null)
				return false;
		} else if (!km.equals(other.km))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (patrocinador == null) {
			if (other.patrocinador != null)
				return false;
		} else if (!patrocinador.equals(other.patrocinador))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	
	
}
