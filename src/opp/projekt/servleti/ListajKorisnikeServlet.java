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

@SuppressWarnings("serial")
@WebServlet("/listajKorisnike")
public class ListajKorisnikeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DAO dao = DAOProvider.getDAO();
		List<Korisnik>korisnici = dao.dohvatiSveKorisnike();
		
		req.setAttribute("korisnici", korisnici);

		req.getRequestDispatcher("/WEB-INF/pages/listajKorisnike.jsp").forward(req, resp);
	}
}
