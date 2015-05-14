package opp.projekt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Razred predstavlja zapis o jednoj knjizi. Zapis sadrži naslov djela, popis
 * autora, datum izdanja knjige, broj stranica, prosječnu ocjenu knjige i razinu
 * stoga kupnje.
 */
@Entity
@Table(name="knjige")
public class Knjiga {

	private Long id;
	private String naslov;
	private String autori;
	private Integer godinaIzdanja;
	private Integer brojStranica;
	private Double ocjenaKnjige;
	private String linkNaKnjigu;
	private String certifikat;
	private String nadimakVlasnika;
	private Double pocetnaCijena;
	private String isbn;
	private List<Komentar> komentari = new ArrayList<>();
	private Double razinaStogaKupnje;
	private String zanr;

	@Id @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=100,nullable=false)
	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	@Column
	public String getAutori() {
		return autori;
	}

	public void setAutori(String autori) {
		this.autori = autori;
	}

	@Column(nullable=false)
	public Integer getBrojStranica() {
		return brojStranica;
	}

	public void setBrojStranica(Integer brojStranica) {
		this.brojStranica = brojStranica;
	}

	@Column(precision=2,nullable=false)
	public Double getOcjenaKnjige() {
		return ocjenaKnjige;
	}

	public void setOcjenaKnjige(Double ocjenaKnjige) {
		this.ocjenaKnjige = ocjenaKnjige;
	}

	@Column(precision=2, nullable=false)
	public Double getRazinaStogaKupnje() {
		return razinaStogaKupnje;
	}

	public void setRazinaStogaKupnje(Double razinaStogaKupnje) {
		this.razinaStogaKupnje = razinaStogaKupnje;
	}

	@OneToMany(mappedBy="knjiga",fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, orphanRemoval=true)
	@OrderBy("datumVrijeme")
	public List<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}

	@Column(nullable=false)
	public Integer getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(Integer godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	@Column(length=100,nullable=false)
	public String getLinkNaKnjigu() {
		return linkNaKnjigu;
	}

	public void setLinkNaKnjigu(String linkNaKnjigu) {
		this.linkNaKnjigu = linkNaKnjigu;
	}

	@Column(length=100,nullable=false)
	public String getCertifikat() {
		return certifikat;
	}

	public void setCertifikat(String certifikat) {
		this.certifikat = certifikat;
	}

	@Column(length=100,nullable=false)
	public String getNadimakVlasnika() {
		return nadimakVlasnika;
	}

	public void setNadimakVlasnika(String nadimakVlasnika) {
		this.nadimakVlasnika = nadimakVlasnika;
	}

	@Column(precision=2,nullable=false)
	public Double getPocetnaCijena() {
		return pocetnaCijena;
	}

	public void setPocetnaCijena(Double pocetnaCijena) {
		this.pocetnaCijena = pocetnaCijena;
	}

	@Column(length=100, nullable=false)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column
	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

}
