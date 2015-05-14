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

@SuppressWarnings("serial")
@WebServlet("/odjava")
public class OdjavaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getServletContext().removeAttribute("korisnik");

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
