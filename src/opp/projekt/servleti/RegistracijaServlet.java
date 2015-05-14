package opp.projekt.servleti;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOProvider;
import opp.projekt.formulari.KorisnikFormular;
import opp.projekt.model.Korisnik;

@SuppressWarnings("serial")
@WebServlet("/registracija")
public class RegistracijaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String metoda = req.getParameter("metoda");

		if (metoda.equals("Odustani")) {
			// Ništa
		} else {

			KorisnikFormular kf = new KorisnikFormular();
			kf.popuniIzHttpZahtjeva(req);

			if (kf.imaPogresaka()) {
				req.setAttribute("zapis", kf);
				req.getRequestDispatcher("/WEB-INF/pages/registracija.jsp")
						.forward(req, resp);
			} else {
				DAO dao = DAOProvider.getDAO();
				Korisnik korisnik = kf.stvoriKorisnika();
				dao.urediKorisnika(korisnik);
			}

		}

		DAO dao = DAOProvider.getDAO();

		long prodaje = dao.brojProdanihKnjiga("knjizara");
		req.setAttribute("prodaje", prodaje);

		int ukupnoKupnji = dao.ukupanBrojKupnji();
		req.setAttribute("ukupnoKupnji", ukupnoKupnji);

		List<String> kupci = dao.najboljiKupci();
		req.setAttribute("kupci", kupci);

		List<String> prodavaci = dao.najboljiProdavaci();
		req.setAttribute("prodavaci", prodavaci);

		req.getRequestDispatcher("/WEB-INF/pages/naslovnica.jsp").forward(req,
				resp);
	}
}
