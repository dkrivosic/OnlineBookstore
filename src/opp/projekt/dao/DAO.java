package opp.projekt.dao;

import java.util.List;

import opp.projekt.model.Knjiga;
import opp.projekt.model.Komentar;
import opp.projekt.model.Korisnik;
import opp.projekt.model.KorisnikKupio;
import opp.projekt.model.Ocjena;

/**
 * Sučelje koje nudi metode za pristup bazi podataka.
 */
public interface DAO {

	/**
	 * Dohvaća korisnika po id-u.
	 * 
	 * @param id
	 *            identifikacijski broj korisnika
	 * @return korisnik sa zadanim id-jem
	 * @throws DAOException
	 *             ako je došlo do pogreške kod dohvaćanja korisnika
	 */
	public Korisnik dohvatiKorisnika(String nadimak) throws DAOException;

	/**
	 * Dohvaća korisnika sa zadanim nadimkom i lozinkom. Koristi se kod
	 * prijavljivanja korisnika.
	 * 
	 * @param nadimak
	 *            nadimak traženog korisnika
	 * @param lozinka
	 *            lozinka traženog korisnika
	 * @return Korisnik ako je pronađen, inače <code>null</code>
	 * @throws DAOException
	 *             ako je došlo do pogreške kod dohvaćanja korisnika
	 */
	public Korisnik dohvatiKorisnika(String nadimak, String lozinka)
			throws DAOException;

	/**
	 * Dohvaća sve registrirane korisnike.
	 * 
	 * @return lista svih korisnika
	 */
	public List<Korisnik> dohvatiSveKorisnike();

	/**
	 * Mijenja podatke korisnika ili stvara novog ako navedeni korisnik već ne
	 * postoji.
	 * 
	 * @param korisnik
	 *            korisnik kojeg treba promijeniti ili stvoriti
	 * @throws DAOException
	 *             ako je došlo do pogreške
	 */
	public void urediKorisnika(Korisnik korisnik) throws DAOException;

	/**
	 * Dodaje novu knjigu u bazu podataka.
	 * 
	 * @param knjiga
	 *            knjiga koju treba dodati u bazu podataka.
	 * @throws DAOException
	 *             ako je došlo do pogreške
	 */
	public void dodajKnjigu(Knjiga knjiga) throws DAOException;

	/**
	 * Dohvaća sve knjige koje se nalaze u bazi podataka.
	 * 
	 * @return lista svih knjiga
	 * @throws DAOException
	 *             ako je došlo do pogreške
	 */
	public List<Knjiga> dohvatiSveKnjige() throws DAOException;

	/**
	 * Metoda kao argument prima neki izraz i vraća sve knjige koje u naslovu
	 * sadrže traženi izraz.
	 * 
	 * @param izraz
	 *            traženi izraz
	 * @return lista knjiga čiji naslovi sadrže traženi izraz ili
	 *         <code>null</code> ako ne postoji takva knjiga.
	 */
	public List<Knjiga> traziKnjiguPoNaslovu(String izraz);

	/**
	 * Metoda kao argument prima neki izraz i vraća sve knjige koje u popisu
	 * autora sadrže traženi izraz.
	 * 
	 * @param izraz
	 *            traženi izraz
	 * @return lista knjiga čiji popis autora sadrži traženi izraz ili
	 *         <code>null</code> ako ne postoji takva knjiga.
	 */
	public List<Knjiga> traziPoAutoru(String izraz);

	/**
	 * Metoda kao argument prima žanr i vraća sve knjige koje su zadanog žanra.
	 * 
	 * @param zanr
	 *            traženi žanr
	 * @return lista knjiga koje su zadanog žanra ili <code>null</code> ako ne
	 *         postoji takva knjiga.
	 */
	public List<Knjiga> traziPoZanru(String zanr);

	/**
	 * Metoda kao argument prima godinu i vraća sve knjige koje su izdane te
	 * godine.
	 * 
	 * @param godina
	 *            tražena godina izdanja
	 * 
	 * @return lista knjiga izdanih zadane godine ili <code>null</code> ako ne
	 *         postoji takva knjiga.
	 */
	public List<Knjiga> traziPoGodiniIzdanja(int godina);

	/**
	 * Dohvaća knjigu sa zadanim id-jem ili <code>null</code> ako knjiga sa
	 * zadanim id-jem ne postoji.
	 * 
	 * @param id
	 *            id tražene knjige
	 * @return knjiga sa traženim id-jem
	 * @throws DAOException
	 *             ako je došlo do pogreške
	 */
	public Knjiga dohvatiKnjigu(Long id) throws DAOException;

	/**
	 * Dohvaća sve knjige iz baze podataka sa zadanim naslovom.
	 * 
	 * @param naslov
	 *            zadani naslov
	 * @return lista knjiga ili <code>null</code> ako nije pronađena niti jedna
	 *         knjiga sa zadanim naslovom
	 */
	public List<Knjiga> dohvatiKnjige(String naslov);

	/**
	 * Dohvaća sve korisnike sa zadanim imenom.
	 * 
	 * @param ime
	 *            zadano ime
	 * @return lista korisnika sa zadanim imenom ili <code>null</code> ako takav
	 *         korisnik nije pronađen
	 */
	public List<Korisnik> traziPoImenu(String ime);

	/**
	 * Dohvaća sve korisnike sa zadanim prezimenom.
	 * 
	 * @param prezime
	 *            zadano prezime
	 * @return lista korisnika sa zadanim prezimenom ili <code>null</code> ako
	 *         takav korisnik nije pronađen
	 */
	public List<Korisnik> traziPoPrezimenu(String prezime);

	/**
	 * Dohvaća sve korisnike čiji nadimak sadrži zadani izraz.
	 * 
	 * @param izraz
	 *            traženi izraz
	 * @return lista korisnika sa traženim nadimkom ili <code>null</code> ako
	 *         takav korisnik nije pronađen
	 */
	public List<Korisnik> traziPoNadimku(String izraz);

	/**
	 * Sprema komentar u bazu podataka.
	 * 
	 * @param komentar
	 *            komentar koji treba spremiti u bazu podataka
	 */
	public void spremiKomentar(Komentar komentar);

	/**
	 * Dohvaća sve komentare za zadanu knjigu.
	 * 
	 * @param knjiga
	 *            knjiga za koju se trebaju dohvatiti komentari
	 * @return lista komentara ili <code>null</code> ako ne postoji nijedan
	 *         komentar na knjigu
	 */
	public List<Komentar> dohvatiKomentareZaKnjigu(Knjiga knjiga);

	/**
	 * Dohvaća pozitivne ili negativne komentare za zadanu knjigu, ovisno o
	 * zastavici <code>pozitivni</code>
	 * 
	 * @param knjiga
	 *            knjiga za koju se trebaju dohvatiti komentari
	 * @param pozitivni
	 *            zastavica koja određuje hoće li se dohvatiti pozitivni ili
	 *            negativni komentari
	 * @return lista komentara ili <code>null</code> ako ne postoji nijedan
	 *         komentar na knjigu
	 */
	public List<Komentar> dohvatiKomentareZaKnjigu(Knjiga knjiga,
			boolean pozitivni);

	/**
	 * Sprema ocjenu knjige za trenutno ulogiranog korisnika u bazu podataka.
	 * Ako je korisnik već ocjenio knjigu, metoda će promijeniti njegovu ocjenu
	 * kako korisnik ne bi mogao dati dvije ocjene za istu knjigu.
	 * 
	 * @param id
	 *            id knjige koja se ocjenjuje
	 * @param nadimak
	 *            nadimak korisnika koji je ocjenio knjigu
	 * @param ocjena
	 *            ocjena koju je korisnik dao za knjigu
	 */
	public void ocjeniKnjigu(Ocjena ocjena);

	/**
	 * Ažurira vrijednost prosječne ocjene u bazi podataka.
	 * 
	 * @param naslovKnjige
	 *            naslov knjige čiju ocjenu treba ažurirati
	 * @param ocjena
	 *            nova ocjena knjige
	 */
	public void azurirajProsjecnuOcjenu(String naslovKnjige, double ocjena);

	/**
	 * Računa prosječnu ocjenu knjige sa zadanim naslovom.
	 * 
	 * @param naslovKnjige
	 *            naslov knjige čiju prosječnu ocjenu treba izračunati.
	 * @return prosječna ocjena knjige
	 */
	public double izracunajProsjecnuOcjenu(String naslovKnjige);

	/**
	 * Sprema zapis o jednoj kupnji/prodaji knjige.
	 * 
	 * @param kupnja
	 *            zapis o kupnji
	 */
	public void spremiKupnju(KorisnikKupio kupnja);

	/**
	 * Briše zadanu knjigu iz baze podataka.
	 * 
	 * @param knjiga
	 *            knjiga koju treba izbrisati
	 */
	public void obrisiKnjigu(Knjiga knjiga);

	public List<String> dohvatiKlijente(String nadimak);

	public List<String> dohvatiPartnere(String nadimak);

	public Long brojKupljenihKnjiga(String nadimak);

	public Long brojProdanihKnjiga(String nadimak);

	public int ukupanBrojKupnji();

	public Double potrosioNovaca(String nadimak);

	public Double zaradioNovaca(String nadimak);

	public List<String> najboljiKupci();

	public List<String> najboljiProdavaci();

	public List<String> najpovoljnijeKnjige();

}