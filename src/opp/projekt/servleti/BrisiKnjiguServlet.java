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

@SuppressWarnings("serial")
@WebServlet("/brisiKnjigu")
public class BrisiKnjiguServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DAO dao = DAOProvider.getDAO();
		
		Long id = Long.parseLong(req.getParameter("id"));
		Knjiga knjiga = dao.dohvatiKnjigu(id);
		dao.obrisiKnjigu(knjiga);
		
		List<Knjiga> knjige = dao.dohvatiSveKnjige();
		req.setAttribute("knjige", knjige);
		
		req.getRequestDispatcher("/WEB-INF/pages/listajKnjige.jsp").forward(req, resp);
	}
}
