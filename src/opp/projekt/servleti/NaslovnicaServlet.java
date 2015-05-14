package opp.projekt.servleti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opp.projekt.dao.DAO;
import opp.projekt.dao.DAOProvider;
import opp.projekt.dao.jpa.JPADAOImpl;
import opp.projekt.dao.jpa.JPAEMFProvider;
import opp.projekt.model.Korisnik;


@SuppressWarnings("serial")
@WebServlet(name="NaslovnicaServlet", urlPatterns={"/naslovna"})
public class NaslovnicaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DAO dao = DAOProvider.getDAO();
		
		long prodaje = dao.brojProdanihKnjiga("knjizara");
		req.setAttribute("prodaje", prodaje);
		
		int ukupnoKupnji = dao.ukupanBrojKupnji();
		req.setAttribute("ukupnoKupnji", ukupnoKupnji);
		
		List<String> kupci = dao.najboljiKupci();
		req.setAttribute("kupci", kupci);
		
		List<String> prodavaci = dao.najboljiProdavaci();
		req.setAttribute("prodavaci", prodavaci);
		
		req.getRequestDispatcher("/WEB-INF/pages/naslovnica.jsp").forward(req, resp);
	}

}
