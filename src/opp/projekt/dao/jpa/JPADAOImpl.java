package opp.projekt.dao.jpa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOException;
import opp.projekt.model.Knjiga;
import opp.projekt.model.Komentar;
import opp.projekt.model.Korisnik;
import opp.projekt.model.KorisnikKupio;
import opp.projekt.model.Ocjena;

public class JPADAOImpl implements DAO {

	@Override
	public Korisnik dohvatiKorisnika(String nadimak) throws DAOException {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Korisnik> korisnici = (List<Korisnik>) em
				.createQuery(
						"select b from Korisnik as b where b.nadimak=:nadimak")
				.setParameter("nadimak", nadimak).getResultList();

		if (korisnici.size() == 0)
			return null;

		return korisnici.get(0);
	}

	@Override
	public Korisnik dohvatiKorisnika(String nadimak, String lozinka)
			throws DAOException {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Korisnik> korisnici = (List<Korisnik>) em
				.createQuery(
						"select b from Korisnik as b where b.nadimak=:nadimak and b.lozinka=:lozinka")
				.setParameter("nadimak", nadimak)
				.setParameter("lozinka", lozinka).getResultList();

		if (korisnici.size() == 0)
			return null;

		return korisnici.get(0);
	}

	@Override
	public List<Korisnik> dohvatiSveKorisnike() {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Korisnik> korisnici = (List<Korisnik>) em.createQuery(
				"from Korisnik").getResultList();
		return korisnici;
	}

	@Override
	public void urediKorisnika(Korisnik korisnik) throws DAOException {
		EntityManager em = JPAEMProvider.getEntityManager();

		if (korisnik.getId() != null) {
			em.merge(korisnik);
		} else {
			em.persist(korisnik);
		}

		em.getTransaction().commit();
	}

	@Override
	public void dodajKnjigu(Knjiga knjiga) throws DAOException {
		EntityManager em = JPAEMProvider.getEntityManager();
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		em.persist(knjiga);
		em.getTransaction().commit();
	}

	@Override
	public List<Knjiga> dohvatiSveKnjige() throws DAOException {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Knjiga> knjige = (List<Knjiga>) em.createQuery("from Knjiga")
				.getResultList();
		return knjige;
	}

	@Override
	public List<Knjiga> traziKnjiguPoNaslovu(String izraz) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Knjiga> knjige = (List<Knjiga>) em
				.createQuery("from Knjiga where naslov like :izraz")
				.setParameter("izraz", "%" + izraz + "%").getResultList();

		return knjige;
	}

	@Override
	public Knjiga dohvatiKnjigu(Long id) throws DAOException {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Knjiga> knjige = (List<Knjiga>) em
				.createQuery("select b from Knjiga as b where b.id=:id")
				.setParameter("id", id).getResultList();

		if (knjige.size() == 0) {
			return null;
		}

		return knjige.get(0);
	}

	@Override
	public List<Knjiga> traziPoAutoru(String izraz) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Knjiga> knjige = (List<Knjiga>) em
				.createQuery("from Knjiga where autori like :izraz")
				.setParameter("izraz", "%" + izraz + "%").getResultList();

		return knjige;
	}

	@Override
	public List<Knjiga> traziPoZanru(String zanr) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Knjiga> knjige = (List<Knjiga>) em
				.createQuery("select b from Knjiga as b where b.zanr=:zanr")
				.setParameter("zanr", zanr).getResultList();

		return knjige;
	}

	@Override
	public List<Knjiga> traziPoGodiniIzdanja(int godina) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Knjiga> knjige = (List<Knjiga>) em
				.createQuery(
						"select b from Knjiga as b where b.godinaIzdanja=:godina")
				.setParameter("godina", godina).getResultList();

		return knjige;
	}

	@Override
	public List<Korisnik> traziPoImenu(String ime) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Korisnik> korisnici = (List<Korisnik>) em
				.createQuery(
						"select b from Korisnik as b where b.ime like :ime")
				.setParameter("ime", "%" + ime + "%").getResultList();

		return korisnici;
	}

	@Override
	public List<Korisnik> traziPoPrezimenu(String prezime) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Korisnik> korisnici = (List<Korisnik>) em
				.createQuery(
						"select b from Korisnik as b where b.prezime like :prezime")
				.setParameter("prezime", "%" + prezime + "%").getResultList();

		return korisnici;
	}

	@Override
	public List<Korisnik> traziPoNadimku(String izraz) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Korisnik> korisnici = (List<Korisnik>) em
				.createQuery("from Korisnik where nadimak like :izraz")
				.setParameter("izraz", "%" + izraz + "%").getResultList();

		return korisnici;
	}

	@Override
	public void spremiKomentar(Komentar komentar) {
		EntityManager em = JPAEMProvider.getEntityManager();
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		em.persist(komentar);
		em.getTransaction().commit();
	}

	@Override
	public List<Komentar> dohvatiKomentareZaKnjigu(Knjiga knjiga) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Komentar> komentari = (List<Komentar>) em
				.createQuery("from Komentar where knjiga=:knjiga")
				.setParameter("knjiga", knjiga).getResultList();

		return komentari;
	}

	@Override
	public List<Komentar> dohvatiKomentareZaKnjigu(Knjiga knjiga,
			boolean pozitivni) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Komentar> komentari = (List<Komentar>) em
				.createQuery(
						"from Komentar where knjiga=:knjiga and pozitivan=:poz")
				.setParameter("knjiga", knjiga).setParameter("poz", pozitivni)
				.getResultList();

		return komentari;
	}

	@Override
	public void ocjeniKnjigu(Ocjena ocjena) {
		EntityManager em = JPAEMProvider.getEntityManager();

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		@SuppressWarnings("unchecked")
		List<Ocjena> ocjene1 = (List<Ocjena>) em
				.createQuery(
						"from Ocjena where naslovKnjige=:naslov and nadimakOsobe like :nadimak")
				.setParameter("naslov", ocjena.getNaslovKnjige())
				.setParameter("nadimak", ocjena.getNadimakOsobe())
				.getResultList();

		if (ocjene1.isEmpty()) {
			em.persist(ocjena);
		} else {
			Ocjena trenutna = ocjene1.get(0);
			em.remove(trenutna);
			em.persist(ocjena);
		}

		em.getTransaction().commit();
	}

	@Override
	public void azurirajProsjecnuOcjenu(String naslovKnjige, double ocjena) {

		// Zaokruzivanje na 2 decimale
		BigDecimal br = new BigDecimal(ocjena);
		br.setScale(2, RoundingMode.HALF_UP);
		ocjena = br.doubleValue();

		EntityManager em = JPAEMProvider.getEntityManager();

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		em.createQuery(
				"update Knjiga set ocjenaKnjige = :ocjenaKnjige where naslov like :naslov")
				.setParameter("ocjenaKnjige", ocjena)
				.setParameter("naslov", naslovKnjige).executeUpdate();

		em.getTransaction().commit();
	}

	@Override
	public double izracunajProsjecnuOcjenu(String naslovKnjige) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Ocjena> sveOcjene = (List<Ocjena>) em
				.createQuery("from Ocjena where naslovKnjige like :naslov")
				.setParameter("naslov", naslovKnjige).getResultList();

		int broj = sveOcjene.size();
		int suma = 0;

		for (Ocjena o : sveOcjene) {
			suma += o.getOcjena();
		}

		double prosjecnaOcjena = (double) suma / broj;
		return prosjecnaOcjena;
	}

	@Override
	public void spremiKupnju(KorisnikKupio kupnja) {
		EntityManager em = JPAEMProvider.getEntityManager();

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		em.persist(kupnja);
		em.getTransaction().commit();

	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {

		EntityManager em = JPAEMProvider.getEntityManager();

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		em.remove(knjiga);

		em.getTransaction().commit();
	}

	@Override
	public List<String> dohvatiKlijente(String nadimak) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<String> kupnje = em
				.createQuery(
						"select distinct nadimakKupca from KorisnikKupio where nadimakProdavaca=:nadimak and nadimakKupca<>:nadimak")
				.setParameter("nadimak", nadimak).getResultList();

		return kupnje;
	}

	@Override
	public List<String> dohvatiPartnere(String nadimak) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<String> korisnici = em
				.createQuery(
						"select distinct nadimakProdavaca from KorisnikKupio where nadimakKupca=:nadimak and nadimakProdavaca<>:nadimak")
				.setParameter("nadimak", nadimak).getResultList();

		return korisnici;
	}

	@Override
	public Long brojKupljenihKnjiga(String nadimak) {

		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Long> broj = (List<Long>) em
				.createQuery(
						"select count(k) from KorisnikKupio k where k.nadimakKupca=:nadimak group by k.nadimakKupca")
				.setParameter("nadimak", nadimak).getResultList();

		if (broj.isEmpty()) {
			return null;
		}

		return broj.get(0);
	}

	@Override
	public Long brojProdanihKnjiga(String nadimak) {

		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Long> broj = (List<Long>) em
				.createQuery(
						"select count(k) from KorisnikKupio k where k.nadimakProdavaca=:nadimak group by k.nadimakProdavaca")
				.setParameter("nadimak", nadimak).getResultList();

		if (broj.isEmpty()) {
			return 0L;
		}

		return broj.get(0);
	}

	@Override
	public Double potrosioNovaca(String nadimak) {

		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Double> broj = (List<Double>) em
				.createQuery(
						"select sum(k.cijena) from KorisnikKupio k where k.nadimakKupca=:nadimak group by k.nadimakKupca")
				.setParameter("nadimak", nadimak).getResultList();

		if (broj.isEmpty()) {
			return null;
		}

		return broj.get(0);
	}

	@Override
	public Double zaradioNovaca(String nadimak) {

		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Double> broj = (List<Double>) em
				.createQuery(
						"select sum(k.cijena) from KorisnikKupio k where k.nadimakProdavaca=:nadimak group by k.nadimakProdavaca")
				.setParameter("nadimak", nadimak).getResultList();

		if (broj.isEmpty()) {
			return null;
		}

		return broj.get(0) * 0.95;
	}

	@Override
	public int ukupanBrojKupnji() {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<KorisnikKupio> lista = (List<KorisnikKupio>) em.createQuery(
				"from KorisnikKupio").getResultList();

		if (lista.isEmpty()) {
			return 0;
		}

		return lista.size();
	}

	@Override
	public List<String> najboljiKupci() {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<String> nadimci = (List<String>) em
				.createQuery(
						"select nadimakKupca from KorisnikKupio group by nadimakKupca order by count(id) desc")
				.getResultList();

		return nadimci;
	}

	@Override
	public List<String> najboljiProdavaci() {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<String> nadimci = (List<String>) em
				.createQuery(
						"select nadimakProdavaca from KorisnikKupio where nadimakProdavaca<>'knjizara' group by nadimakProdavaca order by count(id) desc")
				.getResultList();

		return nadimci;
	}

	@Override
	public List<String> najpovoljnijeKnjige() {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<String> knjige = (List<String>) em
				.createQuery(
						"select naslov from Knjiga group by naslov order by min(pocetnaCijena * razinaStogaKupnje)")
				.getResultList();

		return knjige;
	}

	@Override
	public List<Knjiga> dohvatiKnjige(String naslov) {
		EntityManager em = JPAEMProvider.getEntityManager();

		@SuppressWarnings("unchecked")
		List<Knjiga> knjige = em
				.createQuery("from Knjiga where naslov=:naslov")
				.setParameter("naslov", naslov).getResultList();
		
		return knjige;
	}

}