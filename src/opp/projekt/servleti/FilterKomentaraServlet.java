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
import opp.projekt.model.Komentar;

@SuppressWarnings("serial")
@WebServlet("/filterKomentara")
public class FilterKomentaraServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Long id = Long.parseLong(req.getParameter("id"));
		String filter = req.getParameter("filter");
		
		DAO dao = DAOProvider.getDAO();
		List<Komentar> komentari = null;
		Knjiga knjiga = dao.dohvatiKnjigu(id);
		
		if(filter.equals("pozitivni")) {
			komentari = dao.dohvatiKomentareZaKnjigu(knjiga, true);
		} else if(filter.equals("negativni")) {
			komentari = dao.dohvatiKomentareZaKnjigu(knjiga, false);
		} else {
			komentari = dao.dohvatiKomentareZaKnjigu(knjiga);
		}
		
		req.setAttribute("knjiga", knjiga);
		req.setAttribute("komentari", komentari);
		
		req.getRequestDispatcher("/WEB-INF/pages/pregledKnjige.jsp").forward(req, resp);
	}
}
