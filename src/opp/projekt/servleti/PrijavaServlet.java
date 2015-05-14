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
import opp.projekt.model.Korisnik;

@WebServlet("/prijava")
public class PrijavaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DAO dao = DAOProvider.getDAO();

		long prodaje = dao.brojProdanihKnjiga("knjizara");
		req.setAttribute("prodaje", prodaje);

		int ukupnoKupnji = dao.ukupanBrojKupnji();
		req.setAttribute("ukupnoKupnji", ukupnoKupnji);

		List<String> kupci = dao.najboljiKupci();
		req.setAttribute("kupci", kupci);

		List<String> prodavaci = dao.najboljiProdavaci();
		req.setAttribute("prodavaci", prodavaci);

		String metoda = req.getParameter("metoda");

		if (metoda.equals("Registracija")) {
			req.getRequestDispatcher("/WEB-INF/pages/registracija.jsp")
					.forward(req, resp);
		} else if (metoda.equals("Prijavi se")) {
			String nadimak = req.getParameter("nadimak");
			String lozinka = req.getParameter("lozinka");

			Korisnik korisnik = dao.dohvatiKorisnika(nadimak, lozinka);

			if (korisnik != null) {
				getServletContext().setAttribute("korisnik", korisnik);
				req.getRequestDispatcher("/WEB-INF/pages/naslovnica.jsp")
						.forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/pages/naslovnica.jsp")
						.forward(req, resp);
			}
		}
	}

}
