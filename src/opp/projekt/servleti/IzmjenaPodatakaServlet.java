package opp.projekt.servleti;

import java.io.IOException;

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
@WebServlet("/uredi")
public class IzmjenaPodatakaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Korisnik korisnik = (Korisnik) getServletContext().getAttribute(
				"korisnik");
		KorisnikFormular kf = new KorisnikFormular();
		kf.popuniIzKorisnika(korisnik);
		req.setAttribute("zapis", kf);

		req.getRequestDispatcher("/WEB-INF/pages/izmjenaPodataka.jsp").forward(
				req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String metoda = req.getParameter("metoda");

		if (metoda.equals("Spremi promjene")) {
			KorisnikFormular kf = new KorisnikFormular();
			kf.popuniIzHttpZahtjeva(req);
			Korisnik korisnik = kf.stvoriKorisnika();
			DAO dao = DAOProvider.getDAO();
			dao.urediKorisnika(korisnik);
			req.removeAttribute("zapis");
			req.getServletContext().setAttribute("korisnik", korisnik);
		}

		req.getRequestDispatcher("/WEB-INF/pages/naslovnica.jsp").forward(req,
				resp);
	}
}
