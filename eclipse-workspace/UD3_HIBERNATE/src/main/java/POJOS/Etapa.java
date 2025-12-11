package POJOS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;



@Entity
@Table(name="etapa")
public class Etapa implements Serializable {
	@Id
	private Integer netapa;
	private String salida;
	private String llegada;
	private Integer km;


	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="dorsal")
	private Ciclista ciclista;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="etapa")
	private List<Puerto>puertos= new ArrayList<Puerto>();

	public Etapa() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Etapa(Integer netapa, String salida, String llegada, Integer km, Ciclista ciclista, List<Puerto> puertos) {
		super();
		this.netapa = netapa;
		this.salida = salida;
		this.llegada = llegada;
		this.km = km;
		this.ciclista = ciclista;
		this.puertos = puertos;
	}




	public Integer getNetapa() {
		return netapa;
	}


	public void setNetapa(Integer netapa) {
		this.netapa = netapa;
	}


	public String getSalida() {
		return salida;
	}


	public void setSalida(String salida) {
		this.salida = salida;
	}


	public String getLlegada() {
		return llegada;
	}


	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}


	public Integer getKm() {
		return km;
	}


	public void setKm(Integer km) {
		this.km = km;
	}


	public Ciclista getCiclista() {
		return ciclista;
	}


	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}
	public List<Puerto> getPuertos() {
		return puertos;
	}




	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((netapa == null) ? 0 : netapa.hashCode());
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
		Etapa other = (Etapa) obj;
		if (netapa == null) {
			if (other.netapa != null)
				return false;
		} else if (!netapa.equals(other.netapa))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Etapa [netapa=" + netapa + ", salida=" + salida + ", llegada=" + llegada + ", km=" + km + ", ciclista="
				+ ciclista + "]";
	}




	
	
}
