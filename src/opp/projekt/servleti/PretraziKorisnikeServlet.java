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
import opp.projekt.model.Knjiga;
import opp.projekt.model.Korisnik;

@SuppressWarnings("serial")
@WebServlet("/pretraziKorisnike")
public class PretraziKorisnikeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Korisnik> korisnici = null;
		DAO dao = DAOProvider.getDAO();
		String upit = req.getParameter("upit");
		String tip = req.getParameter("tipPretrage");

		if (upit.isEmpty() || tip == null) {
			korisnici = dao.dohvatiSveKorisnike();
		} else if (tip.equals("ime")) {
			korisnici = dao.traziPoImenu(upit);
		} else if (tip.equals("prezime")) {
			korisnici = dao.traziPoPrezimenu(upit);
		} else if (tip.equals("nadimak")) {
			korisnici = dao.traziPoNadimku(upit);
		}
		

		req.setAttribute("korisnici", korisnici);

		req.getRequestDispatcher("/WEB-INF/pages/listajKorisnike.jsp").forward(
				req, resp);
	}
}
