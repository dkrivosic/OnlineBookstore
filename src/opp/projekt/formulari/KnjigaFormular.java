package opp.projekt.formulari;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import opp.projekt.model.Knjiga;
import opp.projekt.model.Komentar;

public class KnjigaFormular extends HttpServlet {

	private String id;
	private String naslov;
	private String autori;
	private String godinaIzdanja;
	private String brojStranica;
	private String ocjenaKnjige;
	private String linkNaKnjigu;
	private String certifikat;
	private String pocetnaCijena;
	private String isbn;
	private List<Komentar> komentari = new ArrayList<>();
	private String razinaStogaKupnje;
	private String nadimakVlasnika;
	private String zanr;

	private Map<String, String> greske = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getAutori() {
		return autori;
	}

	public void setAutori(String autori) {
		this.autori = autori;
	}

	public String getDatumIzdanja() {
		return godinaIzdanja;
	}

	public void setDatumIzdanja(String datumIzanja) {
		this.godinaIzdanja = datumIzanja;
	}

	public String getBrojStranica() {
		return brojStranica;
	}

	public void setBrojStranica(String brojStranica) {
		this.brojStranica = brojStranica;
	}

	public String getOcjenaKnjige() {
		return ocjenaKnjige;
	}

	public void setOcjenaKnjige(String ocjenaKnjige) {
		this.ocjenaKnjige = ocjenaKnjige;
	}

	public String getLinkNaKnjigu() {
		return linkNaKnjigu;
	}

	public void setLinkNaKnjigu(String linkNaKnjigu) {
		this.linkNaKnjigu = linkNaKnjigu;
	}

	public String getCertifikat() {
		return certifikat;
	}

	public void setCertifikat(String certifikat) {
		this.certifikat = certifikat;
	}

	public String getNadimakVlasnika() {
		return nadimakVlasnika;
	}

	public void setNadimakVlasnika(String nadimakVlasnika) {
		this.nadimakVlasnika = nadimakVlasnika;
	}

	public List<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}

	public String getRazinaStogaKupnje() {
		return razinaStogaKupnje;
	}

	public void setRazinaStogaKupnje(String razinaStogaKupnje) {
		this.razinaStogaKupnje = razinaStogaKupnje;
	}
	
	public String getPocetnaCijena() {
		return pocetnaCijena;
	}

	public void setPocetnaCijena(String pocetnaCijena) {
		this.pocetnaCijena = pocetnaCijena;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public Map<String, String> getGreske() {
		return greske;
	}

	public void setGreske(Map<String, String> greske) {
		this.greske = greske;
	}

	public boolean imaPogresaka() {
		return !greske.isEmpty();
	}

	public boolean imaPogresku(String kljuc) {
		return greske.containsKey(kljuc);
	}

	public String dohvatiPogresku(String kljuc) {
		return greske.get(kljuc);
	}

	public void popuniIzKnjige(Knjiga k) {
		if (k.getId() == null) {
			id = "";
		} else {
			id = k.getId().toString();
		}
		
		naslov = k.getNaslov();
		autori = k.getAutori();
		godinaIzdanja = k.getGodinaIzdanja().toString();
		brojStranica = k.getBrojStranica().toString();
		ocjenaKnjige = k.getOcjenaKnjige().toString();
		komentari = k.getKomentari();
		razinaStogaKupnje = k.getRazinaStogaKupnje().toString();
		linkNaKnjigu = k.getLinkNaKnjigu();
		certifikat = k.getCertifikat();
		nadimakVlasnika = k.getNadimakVlasnika();
		isbn = k.getIsbn();
		pocetnaCijena = k.getPocetnaCijena().toString();
		zanr = k.getZanr();
	}

	public void popuniIzHttpZahtjeva(HttpServletRequest req) {
		id = null;
		naslov = pripremi(req.getParameter("naslov"));
		autori = pripremi(req.getParameter("autori"));
		godinaIzdanja = pripremi(req.getParameter("datumIzdanja"));
		brojStranica = pripremi(req.getParameter("brojStranica"));
		ocjenaKnjige = pripremi(req.getParameter("ocjena"));
		razinaStogaKupnje = pripremi(req.getParameter("razinaStoga"));
		linkNaKnjigu = pripremi(req.getParameter("linkNaKnjigu"));
		certifikat = pripremi(req.getParameter("certifikat"));
		isbn = pripremi(req.getParameter("isbn"));
		pocetnaCijena = pripremi(req.getParameter("pocetnaCijena"));
		zanr = pripremi(req.getParameter("zanr"));
		nadimakVlasnika = "knjizara";
		validiraj();
	}

	private void validiraj() {
		
		// Provjera naslova
		if(naslov.isEmpty()){
			greske.put("naslov", "Knjiga mora imati naslov.");
		}
		
		// Provjera autora
		if (autori.isEmpty()) {
			greske.put("autori", "Knjiga mora imati barem jednog autora.");
		} else if (!samoSlova(autori)) {
			greske.put("autori", "Imena autora moraju se sastojati od slova i biti odvojena zarezom.");
		}

		// Provjera broja stranica
		try {
			Integer.parseInt(brojStranica);
		} catch (NumberFormatException e) {
			greske.put("brojStranica", "Broj stranica mora biti broj.");
		}
		
		// Provjera datuma
		try {
			Integer.parseInt(godinaIzdanja);
		} catch(NumberFormatException e) {
			greske.put("datum", "Godina izdanja mora biti broj.");
		}
		
		// Provjera linka na knjigu
		if(linkNaKnjigu.isEmpty()) {
			greske.put("linkNaKnjigu", "Poveznica na knjigu je obavezna.");
		}
		
		// Provjera certifikata
		if(certifikat.isEmpty()) {
			greske.put("certifikat", "Potrebno je priložiti poveznicu na certifikat autentičnosti.");
		}
		
		// Provjera ISBN-a
		if(isbn.isEmpty()) {
			greske.put("isbn", "ISBN je obavezan.");
		}
		
		// Provjera početne cijene
		try {
			Double.parseDouble(pocetnaCijena);
		} catch (NumberFormatException e) {
			greske.put("cijena", "Početna cijena mora biti broj.");
		}
		
	}

	private boolean samoSlova(String s) {
		for (Character c : s.toCharArray()) {
			if (!Character.isLetter(c) && !c.equals(',') && !c.equals(' ')) {
				return false;
			}
		}
		return true;
	}

	private String pripremi(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}

	public Knjiga stvoriKnjigu() {
		Knjiga k = new Knjiga();
		k.setId(null);
		k.setNaslov(naslov);
		k.setAutori(autori);
		
		int brStr = Integer.parseInt(brojStranica);
		k.setBrojStranica(brStr);
		
		try{
			k.setGodinaIzdanja(Integer.parseInt(godinaIzdanja));
		} catch (NumberFormatException ignorable) {}
		
		Double cijena = Double.parseDouble(pocetnaCijena);
		k.setPocetnaCijena(cijena);
		
		k.setIsbn(isbn);
		k.setRazinaStogaKupnje(1.0);
		k.setLinkNaKnjigu(linkNaKnjigu);
		k.setCertifikat(certifikat);
		k.setNadimakVlasnika(nadimakVlasnika);
		k.setOcjenaKnjige(0.0);
		
		if(zanr.isEmpty()) {
			k.setZanr("nepoznat");
		} else {
			k.setZanr(zanr);
		}
		
		return k;
	}

}
