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
@WebServlet("/pretrazi")
public class PretraziKnjigeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Knjiga> knjige = null;
		DAO dao = DAOProvider.getDAO();
		String upit = req.getParameter("upit");
		String tip = req.getParameter("tipPretrage");

		if (upit.isEmpty() || tip == null) {
			knjige = dao.dohvatiSveKnjige();
		} else if (tip.equals("naslov")) {
			knjige = dao.traziKnjiguPoNaslovu(upit);
		} else if (tip.equals("autori")) {
			knjige = dao.traziPoAutoru(upit);
		} else if (tip.equals("zanr")) {
			knjige = dao.traziPoZanru(upit);
		} else if (tip.equals("godina")) {
			try {
				int godina = Integer.parseInt(upit);
				knjige = dao.traziPoGodiniIzdanja(godina);
			} catch (NumberFormatException e) {
				knjige = dao.dohvatiSveKnjige();
			}
		}

		req.setAttribute("knjige", knjige);

		req.getRequestDispatcher("/WEB-INF/pages/listajKnjige.jsp").forward(
				req, resp);
	}
}
