package POJOS;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Coche")
public class Coche implements Serializable{
	private static final long serialVersionUID = 1L;
	private String matricula;
	private String nomequipo;
	private int km;
	private String patrocinador;
	private String marca;
	
	private String funcion;
	private String tipo;

	//--Clave ajena
	
	
		//Clave ajena con equipo
			@OneToOne(fetch=FetchType.LAZY) 
			@JoinColumn(name= "nomeq") 
			private Equipo equipo;
			
	
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomequipo() {
		return nomequipo;
	}

	public void setNomequipo(String nomequipo) {
		this.nomequipo = nomequipo;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}