package POJOS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import POJOS.Ciclista;

import javax.persistence.*;



@Entity
@Table(name="puerto")
public class Puerto implements Serializable {
	@Id
	private String nompuerto;
	private Integer altura;
	private String categoria;
	private Double pendiente;


	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="netapa") //nombre de la clave ajena en la tabla puerto
	private Etapa etapa;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="dorsal")
	private Ciclista ciclista;
	
	public Puerto() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Puerto(String nompuerto, Integer altura, String categoria, Double pendiente, Etapa etapa,
			Ciclista ciclista) {
		super();
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.etapa = etapa;
		this.ciclista = ciclista;
	}




	public String getNompuerto() {
		return nompuerto;
	}


	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}


	public Integer getAltura() {
		return altura;
	}


	public void setAltura(Integer altura) {
		this.altura = altura;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Double getPendiente() {
		return pendiente;
	}


	public void setPendiente(Double pendiente) {
		this.pendiente = pendiente;
	}


	public Etapa getEtapa() {
		return etapa;
	}


	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}


	public Ciclista getCiclista() {
		return ciclista;
	}




	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((etapa == null) ? 0 : etapa.hashCode());
		result = prime * result + ((nompuerto == null) ? 0 : nompuerto.hashCode());
		result = prime * result + ((pendiente == null) ? 0 : pendiente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Puerto))
			return false;
		Puerto other = (Puerto) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (etapa == null) {
			if (other.etapa != null)
				return false;
		} else if (!etapa.equals(other.etapa))
			return false;
		if (nompuerto == null) {
			if (other.nompuerto != null)
				return false;
		} else if (!nompuerto.equals(other.nompuerto))
			return false;
		if (pendiente == null) {
			if (other.pendiente != null)
				return false;
		} else if (!pendiente.equals(other.pendiente))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Puerto [nompuerto=" + nompuerto + ", altura=" + altura + ", categoria=" + categoria + ", pendiente="
				+ pendiente + ", etapa=" + etapa + "]";
	}


	
	
}
