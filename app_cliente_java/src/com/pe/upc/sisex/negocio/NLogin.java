package com.pe.upc.sisex.negocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NLogin {

	public static String init(HttpServletRequest request, HttpServletResponse response){
		
		request.getSession().invalidate();
		
		return "WEB-INF/pages/login.jsp";
	}
	
	public static String login(HttpServletRequest request, HttpServletResponse response){
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String mensajeError = "Ingrese los datos correctamente";
		if(user.equals("admin")){
			if(pass.equals("admin")){
				
				// logica de logueo
				
				return "WEB-INF/pages/welcome.jsp";
			}else{
				request.setAttribute("mensajeError", mensajeError);
				return "WEB-INF/pages/login.jsp";
			}
		}else{
			request.setAttribute("mensajeError", mensajeError);
			return "WEB-INF/pages/login.jsp";
		}
	}
	public static String welcome(HttpServletRequest request, HttpServletResponse response){
		return "WEB-INF/pages/welcome.jsp";
	}
	
}
