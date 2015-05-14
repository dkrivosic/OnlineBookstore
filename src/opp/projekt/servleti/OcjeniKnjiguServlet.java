package opp.projekt.servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOProvider;
import opp.projekt.model.Knjiga;
import opp.projekt.model.Korisnik;
import opp.projekt.model.Ocjena;

@SuppressWarnings("serial")
@WebServlet("/ocjeni")
public class OcjeniKnjiguServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Long idKnjige = Long.parseLong(req.getParameter("id"));
		int ocjenaKnjige = Integer.parseInt(req.getParameter("ocjena"));
		
		Korisnik korisnik = (Korisnik) getServletContext().getAttribute("korisnik");
		String nadimakKorisnika = korisnik.getNadimak();
		
		DAO dao = DAOProvider.getDAO();
		Knjiga knjiga = dao.dohvatiKnjigu(idKnjige);
		String naslov = knjiga.getNaslov();
		
		Ocjena ocjena = new Ocjena();
		ocjena.setNaslovKnjige(naslov);
		ocjena.setNadimakOsobe(nadimakKorisnika);
		ocjena.setOcjena(ocjenaKnjige);
		
		
		dao.ocjeniKnjigu(ocjena);
		
		double prosjecnaOcjena = dao.izracunajProsjecnuOcjenu(naslov);
		dao.azurirajProsjecnuOcjenu(naslov, prosjecnaOcjena);
		Knjiga knjigaZaPrikaz = dao.dohvatiKnjigu(idKnjige);
		
		req.setAttribute("knjiga", knjigaZaPrikaz);
		
		req.getRequestDispatcher("/WEB-INF/pages/pregledKnjige.jsp").forward(req, resp);
	}
}
