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

/**
 * Servlet implementation class ConversionServlet
 */
@WebServlet("/conversionServlet")
public class ConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversionServlet() {
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
		//recuperer montant
		double montant = Double.parseDouble( request.getParameter("montant") );
		
		//convertir
		//creer un stub
		BanqueWS stub;
		try {
			stub = new BanqueServiceServiceLocator().getBanqueWSPort();
			//Appel methode conversion
			double res = stub.conversionEuroToFranc(montant);
			
			//replacer en vue
			System.out.println(res);
			request.getSession().setAttribute("montantConverti", res);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		
		//retourner vers vue
		request.getRequestDispatcher("conversion.jsp").forward(request, response);
	}

}
