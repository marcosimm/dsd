package com.pe.upc.sisex.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.upc.sisex.negocio.NConsultas;
import com.pe.upc.sisex.negocio.NLogin;

/**
 * Servlet implementation class SRedirecciona
 */
public class SRedirecciona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SRedirecciona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String destino = request.getParameter("go");
		int intDestino = destino!=null?Integer.parseInt(destino):-1;
		String pagina = "";
		try {
			switch (intDestino) {
				case 0:	pagina = NLogin.init(request, response); break;
				case 1: pagina = NConsultas.consultaProveedor(request, response); break;
				case 2: pagina = NConsultas.consultaPorRuc(request, response); break;
				case 3: pagina = NConsultas.viewConsultarRUC(request, response); break;
				case 4: pagina = NConsultas.consultarRUC(request, response); break;
				default: pagina = NLogin.welcome(request, response); break;
			}
			System.out.println("Go: "+intDestino+", Se redirecciona a : "+pagina);
			if(pagina.length() > 0){
				request.getRequestDispatcher(pagina).forward(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
