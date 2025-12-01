package POJOS;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="etapa") //nombre de tabla
public class Etapa implements Serializable {

@Column(name="netapa") //valores de columna etapa
private int netapa;
private int km;
private String salida;
private String llegada;

@ManyToOne(fetch=FetchType.LAZY) //poner siempre lazy en manytoone
@JoinColumn(name= "dorsal") //poner el que es clave ajena (en etapa es 'dorsal'), se ve en foreign keys
private Ciclista ciclista;

@OneToMany(fetch = FetchType.LAZY)
@JoinColumn(name="salida")
private Puerto puerto;

@OneToMany(fetch = FetchType.LAZY)
@JoinColumn(name="llevar")
private Llevar llevar;
}
