package POJOS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;



@Entity
@Table(name="premios")
public class Premio implements Serializable {
	@Id
	private Integer codigo;
	private String descripcion;
	private Integer cantidad;


	@ManyToMany
	@JoinTable(name="gana",
	joinColumns= {@JoinColumn(name="premio",
			referencedColumnName="codigo")},
	inverseJoinColumns= {@JoinColumn(name="dorsal",
			referencedColumnName="dorsal")})
	
private List<Ciclista>ciclistas=new ArrayList<Ciclista>();


	public Premio(Integer codigo, String descripcion, Integer cantidad, List<Ciclista> ciclistas) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.ciclistas = ciclistas;
	}


	public Premio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}


	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((ciclistas == null) ? 0 : ciclistas.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
		Premio other = (Premio) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (ciclistas == null) {
			if (other.ciclistas != null)
				return false;
		} else if (!ciclistas.equals(other.ciclistas))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
}
