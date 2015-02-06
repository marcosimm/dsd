package com.pe.upc.sisex.negocio;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
//import org.codehaus.jackson.map.ObjectMapper;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.codehaus.jackson.map.ObjectMapper;

import com.pe.upc.sisex.bean.DatosSunat;
import com.pe.upc.sisex.bean.RiesgoDTO;
import com.pe.upc.sisex.util.RestClient;
import com.pe.upc.sisex.util.UtilProperties;

public class NConsultas {
	
	static String fichero = "com.pe.upc.sisex.util.servicios";
	
	public static String consultaProveedor(HttpServletRequest request, HttpServletResponse response){
		String pagina = "WEB-INF/pages/consultaProveedor.jsp";
		request.setAttribute("active", "p");
		return pagina;
	}
	
	public static String consultaPorRuc(HttpServletRequest request, HttpServletResponse response){
		String pagina = "WEB-INF/pages/consultaProveedor.jsp";
		try {
			String rucService = UtilProperties.getMessage(fichero, "RUC_SERVICE");
			String ruc = request.getParameter("ruc");
			rucService += ruc;
			
			String responseJson = RestClient.getJson(rucService, "GET");
			DatosSunat datos = new DatosSunat();
			ObjectMapper mapper = new ObjectMapper();
			datos  = mapper.readValue(responseJson, DatosSunat.class);
			
			request.setAttribute("datosSunat", datos);
			request.setAttribute("active", "p");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagina;
	}
	
	public static String viewConsultarRUC(HttpServletRequest request, HttpServletResponse response){
		String pagina = "WEB-INF/pages/consultaRUC.jsp";
		request.setAttribute("active", "r");
		return pagina;
	}
	
	public static String consultarRUC(HttpServletRequest request, HttpServletResponse response){
		String pagina = "WEB-INF/pages/consultaRUC.jsp";
		
		try {
			String ruc = request.getParameter("ruc");
			String rucService = UtilProperties.getMessage(fichero, "RUC_SERVICE_SOAP");
			Call objCall = RestClient.getCallService(rucService);
			
			objCall.registerTypeMapping(RiesgoDTO.class, new QName("http://beans.distribuidos.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://services.distribuidos.upc.edu.pe","buscarRiesgoPorRuc"));
			objCall.addParameter("ruc", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.setReturnClass(RiesgoDTO[].class);
			
			RiesgoDTO[] riesgoDTOs = (RiesgoDTO[])objCall.invoke(new Object[]{ruc});
			ArrayList<RiesgoDTO> lstRiesgoDTO = new ArrayList<RiesgoDTO>();
			
			for(RiesgoDTO serv : riesgoDTOs){
				lstRiesgoDTO.add(serv);
			}
			
			request.setAttribute("lstRiesgoDTO", lstRiesgoDTO);
			request.setAttribute("ruc", ruc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("active", "r");
		return pagina;
	}
}
