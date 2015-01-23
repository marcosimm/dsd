package pe.edu.upc.distribuidos.despachadores;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.distribuidos.beans.RiesgoDTO;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class MySqlRiesgo extends SqlMapDaoTemplate implements IDespachadorRiesgo {

	public MySqlRiesgo(DaoManager daoManager) {
		super(daoManager);
	}

	@SuppressWarnings("unchecked")
	public List<RiesgoDTO> buscarRiesgoPorRuc(String ruc) {
		System.out.println("RUC :"+ruc);
		ArrayList<RiesgoDTO> lstRiesgoDTO = (ArrayList<RiesgoDTO>) queryForList("sp_riesgo_ruc", ruc);
		return lstRiesgoDTO;
	}

}
