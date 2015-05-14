package opp.projekt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Razred označava jednu ocjenu korisnika. Zapis o ocjeni sadržava ime korisnika
 * koji je ocjenio knjigu i ocjenu.
 */
@Entity
@Table(name = "ocjene")
public class Ocjena {

	private Long id;
	private String naslovKnjige;
	private String nadimakOsobe;
	private Integer ocjena;

	@Column(length = 100, nullable = false)
	public String getNadimakOsobe() {
		return nadimakOsobe;
	}

	public void setNadimakOsobe(String nadimakOsobe) {
		this.nadimakOsobe = nadimakOsobe;
	}

	@Column(nullable = false)
	public Integer getOcjena() {
		return ocjena;
	}

	public void setOcjena(Integer ocjena) {
		this.ocjena = ocjena;
	}

	@Column(nullable = false)
	public String getNaslovKnjige() {
		return naslovKnjige;
	}

	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}

	 @Id @GeneratedValue
	 public Long getId() {
	 return id;
	 }
	
	 public void setId(Long idOcjene) {
	 this.id = idOcjene;
	 }

}
