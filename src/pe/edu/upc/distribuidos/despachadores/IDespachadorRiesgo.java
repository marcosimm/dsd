package pe.edu.upc.distribuidos.despachadores;

import java.util.List;

import pe.edu.upc.distribuidos.beans.RiesgoDTO;

public interface IDespachadorRiesgo {

	public List<RiesgoDTO> buscarRiesgoPorRuc(String ruc);
	
}
