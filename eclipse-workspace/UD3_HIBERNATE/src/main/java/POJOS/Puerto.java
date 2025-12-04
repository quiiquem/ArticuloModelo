package POJOS;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="puerto")
public class Puerto implements Serializable{

	public Puerto(String nompuerto,int altura, String categoria, Double pendiente,Etapa e, Ciclista d) {
	
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
	}


	//Propiedades puerto
	@Column(name = "puerto")
	private String nompuerto;
	private int altura;
	private String categoria;
	private Double pendiente;
	
	
	
	//--Claves ajenas
	
	//Clave ajena con ciclista
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name= "dorsal") 
	private Ciclista ciclista;
	
	//Clave ajena con etapa
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name= "netapa") 
	private Etapa etapa;
	
	

	public String getNompuerto() {
		return nompuerto;
	}

	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
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

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}
}
