package fr.adaming;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import fr.adaming.service.BanqueServiceServiceLocator;
import fr.adaming.service.BanqueWS;
import fr.adaming.service.Compte;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/compteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer id
		Long idCompte = Long.parseLong( request.getParameter("id") );

		//creer un stub
		BanqueWS stub;
		try {
			stub = new BanqueServiceServiceLocator().getBanqueWSPort();
			//Appel methode conversion
			Compte c = stub.getCompte(idCompte);

			//replacer en vue
			System.out.println(c);
			request.getSession().setAttribute("compte", c);

		} catch (ServiceException e) {
			e.printStackTrace();
		}


		//retourner vers vue
		request.getRequestDispatcher("compte.jsp").forward(request, response);
	}

}
