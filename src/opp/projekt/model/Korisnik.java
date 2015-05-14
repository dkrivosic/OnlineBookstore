package opp.projekt.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Razred predstavlja zapis o jednom korisniku. Zapis sadrži ime, prezime i
 * nadimak korisnika, njegovu e-mail adresu te korisničko ime i lozinku za
 * prijavu na sustav.
 */
@Entity
@Table(name = "korisnici")
@Cacheable(true)
public class Korisnik {

	private Long id;
	private String ime;
	private String prezime;
	private String nadimak;
	private String email;
	private String lozinka;

	@Id @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=50, nullable=false)
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	@Column(length=50, nullable=false)
	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Column(length=20, nullable=false, unique=true)
	public String getNadimak() {
		return nadimak;
	}

	public void setNadimak(String nadimak) {
		this.nadimak = nadimak;
	}

	@Column(length=50, nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=20, nullable=false)
	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Korisnik other = (Korisnik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nadimak;
	}
}
