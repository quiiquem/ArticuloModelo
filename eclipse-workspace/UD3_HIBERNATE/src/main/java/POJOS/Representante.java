package POJOS;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "representante")
public class Representante implements Serializable{
	private static final long serialVersionUID = 1L;

	private int ID;
	private String nombre;
	private String nom_eq;
	
}
