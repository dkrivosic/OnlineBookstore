package opp.projekt.servleti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOProvider;
import opp.projekt.model.Knjiga;
import opp.projekt.model.Komentar;

@SuppressWarnings("serial")
@WebServlet("/spremiKomentar")
public class SpremiKomentarServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DAO dao = DAOProvider.getDAO();

		long id = Long.parseLong(req.getParameter("id"));
		Knjiga odabranaKnjiga = dao.dohvatiKnjigu(id);
		String naslov = odabranaKnjiga.getNaslov();
		List<Knjiga> knjige = dao.dohvatiKnjige(naslov);

		String nadimak = req.getParameter("nadimak");
		String tekst = req.getParameter("tekst");
		boolean pozitivan = Boolean.parseBoolean(req.getParameter("like"));
		Date datumVrijeme = new Date();
		String metoda = req.getParameter("metoda");

		List<Komentar> komentari = new ArrayList<Komentar>();

		for (Knjiga knjiga : knjige) {
			Komentar komentar = new Komentar();
			komentar.setKnjiga(knjiga);
			komentar.setNadimakOsobe(nadimak);
			komentar.setTekstKomentara(tekst);
			komentar.setDatumVrijeme(datumVrijeme);
			komentar.setPozitivan(pozitivan);

			komentari.add(komentar);
		}

		req.setAttribute("knjiga", odabranaKnjiga);

		if (!metoda.equals("Odustani")) {
			for (Komentar komentar : komentari) {
				dao.spremiKomentar(komentar);
			}
		}

		List<Komentar> komentariZaIspis = dao.dohvatiKomentareZaKnjigu(odabranaKnjiga);
		req.setAttribute("komentari", komentariZaIspis);

		req.getRequestDispatcher("/WEB-INF/pages/pregledKnjige.jsp").forward(
				req, resp);

	}
}
