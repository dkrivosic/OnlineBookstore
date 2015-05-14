package opp.projekt.servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOProvider;
import opp.projekt.model.Korisnik;

@SuppressWarnings("serial")
@WebServlet("/pregledajKorisnika")
public class PregledajKorisnikaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DAO dao = DAOProvider.getDAO();
		String nadimak = req.getParameter("nadimak");
		Korisnik korisnik = dao.dohvatiKorisnika(nadimak);
		req.setAttribute("korisnik", korisnik);
		
		long brojKupljenih = dao.brojKupljenihKnjiga(nadimak);
		req.setAttribute("brojKupljenih", brojKupljenih);
		
		long brojProdanih = dao.brojProdanihKnjiga(nadimak);
		req.setAttribute("brojProdanih", brojProdanih);
		
		double potroseno = dao.potrosioNovaca(nadimak);
		req.setAttribute("potroseno", potroseno);
		
		double zaradio = dao.zaradioNovaca(nadimak);
		req.setAttribute("zaradio", zaradio);
		
		req.getRequestDispatcher("/WEB-INF/pages/pregledKorisnika.jsp").forward(req, resp);
	}
}
