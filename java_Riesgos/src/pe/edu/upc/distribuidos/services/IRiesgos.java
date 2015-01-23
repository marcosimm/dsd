package pe.edu.upc.distribuidos.services;

import pe.edu.upc.distribuidos.beans.RiesgoDTO;

public interface IRiesgos {

	public RiesgoDTO[] buscarRiesgoPorRuc(String ruc);
	
}
