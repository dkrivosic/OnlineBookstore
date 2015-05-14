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
@WebServlet("/pregledajKnjigu")
public class PregledajKnjiguServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DAO dao = DAOProvider.getDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		Knjiga knjiga = dao.dohvatiKnjigu(id);
		req.setAttribute("knjiga", knjiga);
		
		List<Komentar> komentari = dao.dohvatiKomentareZaKnjigu(knjiga);
		req.setAttribute("komentari", komentari);
		
		req.getRequestDispatcher("/WEB-INF/pages/pregledKnjige.jsp").forward(req, resp);
	}
}
