package opp.projekt.servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opp.projekt.formulari.KnjigaFormular;

@SuppressWarnings("serial")
@WebServlet("/dodajKnjigu")
public class DodajKnjiguServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		KnjigaFormular kf = new KnjigaFormular();
		req.setAttribute("zapis", kf);
		
		req.getRequestDispatcher("/WEB-INF/pages/novaKnjiga.jsp").forward(req, resp);
	}
}
