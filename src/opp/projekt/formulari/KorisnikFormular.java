package opp.projekt.formulari;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOProvider;
import opp.projekt.model.Korisnik;

public class KorisnikFormular {

	private String id;
	private String ime;
	private String prezime;
	private String nadimak;
	private String email;
	private String lozinka;
	private String kontrola;

	private Map<String, String> greske = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getNadimak() {
		return nadimak;
	}

	public void setNadimak(String nadimak) {
		this.nadimak = nadimak;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
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

	public void popuniIzKorisnika(Korisnik k) {
		if (k.getId() == null) {
			id = "";
		} else {
			id = k.getId().toString();
		}

		ime = k.getIme();
		prezime = k.getPrezime();
		nadimak = k.getNadimak();
		email = k.getEmail();
		lozinka = k.getLozinka();
		kontrola = lozinka;
	}

	public void popuniIzHttpZahtjeva(HttpServletRequest req) {
		id = pripremi(req.getParameter("id"));
		ime = pripremi(req.getParameter("ime"));
		prezime = pripremi(req.getParameter("prezime"));
		nadimak = pripremi(req.getParameter("nadimak"));
		email = pripremi(req.getParameter("email"));
		lozinka = pripremi(req.getParameter("lozinka"));
		kontrola = pripremi(req.getParameter("kontrola"));
		validiraj();
	}

	private void validiraj() {
		// Provjera imena
		if (ime.isEmpty()) {
			greske.put("ime", "Ime ne smije ostati prazno.");
		} else if (!samoSlova(ime)) {
			greske.put("ime", "Ime smije sadržavati samo slova.");
		}

		// Provjera prezimena
		if (prezime.isEmpty()) {
			greske.put("prezime", "Prezime ne smije ostati prazno.");
		} else if (!samoSlova(prezime)) {
			greske.put("prezime", "prezime smije sadržavati samo slova.");
		}

		// Provjera nadimka
		if (nadimak.isEmpty()) {
			greske.put("nadimak", "Nadimak ne smije ostati prazan.");
		} else {
			DAO dao = DAOProvider.getDAO();
			Korisnik k = dao.dohvatiKorisnika(nadimak);
			if (k != null) {
				greske.put("nadimak",
						"Korisnik s navedenim nadimkom već postoji.");
			}
		}
		// Provjera e-maila
		if (!email.contains("@")) {
			greske.put("email", "e-mail mora biti oblika primjer@mail.hr");
		}

		// Provjera lozinke
		if (!lozinka.equals(kontrola)) {
			greske.put("kontrola", "Lozinke se ne poklapaju.");
		}
	}

	private boolean samoSlova(String s) {
		for (char c : s.toCharArray()) {
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == 'č'
					|| c == 'Č' || c == 'ć' || c == 'Ć' || c == 'đ' || c == 'Đ'
					|| c == 'ž' || c == 'Ž' || c == 'š' || c == 'Š')) {
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

	public Korisnik stvoriKorisnika() {
		Korisnik k = new Korisnik();
		k.setId(id.isEmpty() ? null : Long.parseLong(id));
		k.setIme(ime);
		k.setPrezime(prezime);
		k.setNadimak(nadimak);
		k.setEmail(email);
		k.setLozinka(lozinka);

		return k;
	}

}
