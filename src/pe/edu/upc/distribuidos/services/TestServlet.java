package pe.edu.upc.distribuidos.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.upc.distribuidos.beans.RiesgoDTO;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ImplRiesgos riesgo = new ImplRiesgos();
		String ruc = "12345678";
		ArrayList<RiesgoDTO> lstRiesgoDTO = (ArrayList<RiesgoDTO>) riesgo.buscarRiesgoPorRuc(ruc);
	
		for(RiesgoDTO r : lstRiesgoDTO){
			System.out.println(r.getId());
			System.out.println(r.getScore());
			System.out.println(r.getMontoTotal());
			System.out.println(r.getVariacion());
			System.out.println(r.getActual());
			System.out.println(r.getSemestre());
			System.out.println(r.getAnual());
			System.out.println(r.getRuc());
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
