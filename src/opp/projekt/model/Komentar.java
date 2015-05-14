package opp.projekt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Razred predstavlja jedan komentar na knjigu. Zapis komentara sastoji se od
 * nadimka osobe koja je poslala komentar, vremena kada je komentar poslan,
 * teksta komentara i zastavice koja označava je li komentar pozitivan (ako je
 * zastavica postavljena na flase, komentar je negativan).
 */
@Entity
@Table(name = "komentari")
public class Komentar {

	private Long id;
	private String nadimakOsobe;
	private Date datumVrijeme;
	private String tekstKomentara;
	private boolean pozitivan;
	private Knjiga knjiga;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNadimakOsobe() {
		return nadimakOsobe;
	}

	public void setNadimakOsobe(String nadimakOsobe) {
		this.nadimakOsobe = nadimakOsobe;
	}

	public Date getDatumVrijeme() {
		return datumVrijeme;
	}

	public void setDatumVrijeme(Date datumVrijeme) {
		this.datumVrijeme = datumVrijeme;
	}

	public String getTekstKomentara() {
		return tekstKomentara;
	}

	public void setTekstKomentara(String tekstKomentara) {
		this.tekstKomentara = tekstKomentara;
	}

	public boolean isPozitivan() {
		return pozitivan;
	}

	public void setPozitivan(boolean pozitivan) {
		this.pozitivan = pozitivan;
	}

	@ManyToOne
	@JoinColumn(nullable = false)
	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	@Override
	public String toString() {
		return "[" + nadimakOsobe + "]" + "[" + datumVrijeme + "]["
				+ (pozitivan ? "+" : "-") + "]: " + tekstKomentara;
	}
}
