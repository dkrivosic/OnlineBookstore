package opp.projekt.servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/komentiraj")
public class KomentirajKnjiguServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		req.getRequestDispatcher("/WEB-INF/pages/komentarObrazac.jsp").forward(req, resp);
	}
}
