package opp.projekt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Razred označava jedan zapis o kupnji knjige. Zapis o kupnji sadrži cijenu po
 * kojoj je knjiga kupljena (prodana), točno vrijeme transakcije id knjige koja
 * je kupljena/prodana te nadimke kupca i prodavača.
 */
@Entity
@Table(name = "kupnje")
public class KorisnikKupio {

	private Long id;
	private String nadimakKupca;
	private String nadimakProdavaca;
	private Long idKnjige;
	private Double cijena;
	private Date datumVrijeme;

	@Id @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getNadimakKupca() {
		return nadimakKupca;
	}

	public void setNadimakKupca(String nadimakKupca) {
		this.nadimakKupca = nadimakKupca;
	}

	@Column(nullable = false)
	public String getNadimakProdavaca() {
		return nadimakProdavaca;
	}

	public void setNadimakProdavaca(String nadimakProdavaca) {
		this.nadimakProdavaca = nadimakProdavaca;
	}

	@Column(nullable = false)
	public Long getIdKnjige() {
		return idKnjige;
	}

	public void setIdKnjige(Long idKnjige) {
		this.idKnjige = idKnjige;
	}

	@Column(nullable = false, precision = 2)
	public Double getCijena() {
		return cijena;
	}

	public void setCijena(Double cijena) {
		this.cijena = cijena;
	}

	@Column
	public Date getDatumVrijeme() {
		return datumVrijeme;
	}

	public void setDatumVrijeme(Date datumVrijeme) {
		this.datumVrijeme = datumVrijeme;
	}

}
