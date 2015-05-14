package opp.projekt.servleti;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOProvider;
import opp.projekt.formulari.KnjigaFormular;
import opp.projekt.model.Knjiga;
import opp.projekt.model.Korisnik;
import opp.projekt.model.KorisnikKupio;

@SuppressWarnings("serial")
@WebServlet("/kupi")
public class KupiKnjiguServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DAO dao = DAOProvider.getDAO();

		String metoda = req.getParameter("metoda");
		if (metoda.equals("Nazad")) {
			List<Knjiga> knjige = dao.dohvatiSveKnjige();
			req.setAttribute("knjige", knjige);
			req.getRequestDispatcher("/WEB-INF/pages/listajKnjige.jsp")
					.forward(req, resp);
		} else if (metoda.equals("Kupi")) {

			String nadimakProdavaca = req.getParameter("nadimakVlasnika");
			String nadimakKupca = ((Korisnik) req.getServletContext()
					.getAttribute("korisnik")).getNadimak();
			long idKnjige = Long.parseLong(req.getParameter("id"));
			System.out.println("Cijena: " + req.getParameter("cijena"));
			double cijena = Double.parseDouble(req.getParameter("cijena"));
			Date datumVrijeme = new Date();

			KorisnikKupio transakcija = new KorisnikKupio();
			transakcija.setId(null);
			transakcija.setCijena(cijena);
			transakcija.setDatumVrijeme(datumVrijeme);
			transakcija.setIdKnjige(idKnjige);
			transakcija.setNadimakKupca(nadimakKupca);
			transakcija.setNadimakProdavaca(nadimakProdavaca);
			
			Double razinaStoga = Double.parseDouble(req.getParameter("razinaStoga"));

			KnjigaFormular kf = new KnjigaFormular();
			kf.popuniIzHttpZahtjeva(req);
			Knjiga novaKnjiga = kf.stvoriKnjigu();
			novaKnjiga.setRazinaStogaKupnje(izracunajRazinuStoga(razinaStoga));
			novaKnjiga.setNadimakVlasnika(nadimakKupca);
			novaKnjiga.setId(null);

			dao.spremiKupnju(transakcija);
			dao.dodajKnjigu(novaKnjiga);

			req.setAttribute("knjiga", novaKnjiga);
		}

		req.getRequestDispatcher("/WEB-INF/pages/uspjesnaKupnja.jsp").forward(req,
				resp);
	}

	private double izracunajRazinuStoga(double trenutna) {
		if (trenutna > 0.4) {
			trenutna -= 0.1;
		} else if (trenutna > 0.15) {
			trenutna -= 0.05;
		}

		return trenutna;
	}

}
