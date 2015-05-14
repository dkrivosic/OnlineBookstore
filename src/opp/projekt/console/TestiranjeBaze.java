package opp.projekt.console;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import opp.projekt.model.Korisnik;


public class TestiranjeBaze {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("baza.podataka.za.testiranje");
		
		System.out.println("Dodajem korisnika.");
		Korisnik korisnik = dodajKorisnika(emf);
		System.out.println("Dodajem korisnika - gotovo.");
		System.out.println("Korisnik: " + korisnik);
	}
	
	public static Korisnik dodajKorisnika(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Korisnik korisnik = new Korisnik();
		korisnik.setIme("Domagoj");
		korisnik.setPrezime("Krivosic");
		korisnik.setNadimak("domi");
		korisnik.setLozinka("domagoj");
		korisnik.setEmail("domagoj_70@hotmail.com");
		
		em.persist(korisnik);
		
		em.getTransaction().commit();
		em.close();
		
		return korisnik;
	}
}
