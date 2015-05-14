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
import opp.projekt.model.KorisnikKupio;

@SuppressWarnings("serial")
@WebServlet("/klijentiPartneri")
public class PopisKlijenataPartneraServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Korisnik korisnik = (Korisnik) req.getServletContext().getAttribute("korisnik");
		
		DAO dao = DAOProvider.getDAO();
		
		List<String> klijenti = dao.dohvatiKlijente(korisnik.getNadimak());
		List<String> partneri = dao.dohvatiPartnere(korisnik.getNadimak());
		
		req.setAttribute("klijenti", klijenti);
		req.setAttribute("partneri", partneri);
		
		req.getRequestDispatcher("/WEB-INF/pages/klijentiPartneri.jsp").forward(req, resp);
	}
}
