package POJOS;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ciclista") //Nombre de la tabla de la BD 
public class Ciclista implements Serializable{ 
@Id
@GeneratedValue(strategy=GenerationType.AUTO) //Indica que el valor generado es auto (lo podemos comprobar en la BD de SQL)
private Integer dorsal;
private String nombre;
private Date nacimiento;


//conectar a otras tablas

//Equipo
@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
@JoinColumn(name= "nomeq") //Hacer un Join poniendo el nombre de la clave ajena (en este caso N:1, asi que es manytoone)
private Equipo equipo; //guardar la tabla


//Etapa
@OneToMany(mappedBy="ciclista", fetch=FetchType.LAZY) //buscar conexion con etapa 
private List<Etapa> etapasganadas = new ArrayList<Etapa>(); //lista de los ciclista

@ManyToMany(fetch= FetchType.LAZY, mappedBy="ciclistas")
List<Premio> premios = new ArrayList<Premio>();

@OneToMany(fetch= FetchType.LAZY, mappedBy="ciclistas")
List<Puerto> puertos = new ArrayList<Puerto>();

@OneToMany(mappedBy="ciclista", fetch=FetchType.LAZY)
List<Llevar> llevan = new ArrayList<Llevar>();

@Override
public int hashCode() {
	return Objects.hash(dorsal, nacimiento, nombre);
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
	return Objects.equals(dorsal, other.dorsal) && Objects.equals(nacimiento, other.nacimiento)
			&& Objects.equals(nombre, other.nombre);
}

@Override
public String toString() {
	return "Ciclista [dorsal=" + dorsal + ", nombre=" + nombre + ", nacimiento=" + nacimiento + "]";
}

public Integer getDorsal() {
	return dorsal;
}



public Date getNacimiento() {
	return nacimiento;
}

public String getNombre() {
	return nombre;
}

public void setDorsal(Integer dorsal) {
	this.dorsal = dorsal;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}


public void setNacimiento(Date nacimiento) {
	this.nacimiento = nacimiento;
}


}
