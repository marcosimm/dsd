package pe.edu.upc.distribuidos.services;

import java.util.ArrayList;

import pe.edu.upc.distribuidos.beans.RiesgoDTO;
import pe.edu.upc.distribuidos.despachadores.IDespachadorRiesgo;
import pe.edu.upc.distribuidos.utilitarios.UtilDaoConfig;

import com.ibatis.dao.client.DaoManager;

public class ImplRiesgos implements IRiesgos {
	
	DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
	IDespachadorRiesgo despachadorRiesgo = (IDespachadorRiesgo)fabrica.getDao(IDespachadorRiesgo.class);
	
	@Override
	public RiesgoDTO[] buscarRiesgoPorRuc(String ruc) {
		ArrayList<RiesgoDTO> lstRiesgoDTO = (ArrayList<RiesgoDTO>) despachadorRiesgo.buscarRiesgoPorRuc(ruc);
		System.out.println("--->"+ruc);
		//(ServicioDTO[]) servicio.toArray(new ServicioDTO[servicio.size()]);
		return (RiesgoDTO[])lstRiesgoDTO.toArray(new RiesgoDTO[lstRiesgoDTO.size()]);
	}

	

}
