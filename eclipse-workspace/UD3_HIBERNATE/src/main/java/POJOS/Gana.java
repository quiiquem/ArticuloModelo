package POJOS;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Gana")
public class Gana implements Serializable {
	
	@ManyToMany
	@JoinColumn(name="premio")
	private Premio premio;
	@ManyToMany
	@JoinColumn(name="dorsal")
	private Ciclista ciclista;

}
