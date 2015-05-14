package opp.projekt.dao.jpa;
import javax.persistence.EntityManagerFactory;

/**
 * Singleton razred koji vraća instancu razreda <code>EntityManagerFactory</code>. 
 */
public class JPAEMFProvider {

	public static EntityManagerFactory emf;

	/**
	 * @return Instanca <code>EntityManagerFactory</code> razreda
	 */
	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setEmf(EntityManagerFactory emf) {
		JPAEMFProvider.emf = emf;
	}
}