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
 * Servlet implementation class ComptesServlet
 */
@WebServlet("/comptesServlet")
public class ComptesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComptesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//creer un stub
		BanqueWS stub;
		try {
			stub = new BanqueServiceServiceLocator().getBanqueWSPort();
			//Appel methode conversion
			Compte[] comptes = stub.getComptes();

			//replacer en vue
			for(Compte c : comptes) {
				System.out.println(c);
			}
			//System.out.println(comptes);
			request.getSession().setAttribute("comptes", comptes);

		} catch (ServiceException e) {
			e.printStackTrace();
		}


		//retourner vers vue
		request.getRequestDispatcher("comptes.jsp").forward(request, response);
	}

}
