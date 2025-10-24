package co.edu.unbosque.model;

import java.util.Properties;

import co.edu.unbosque.model.persistence.*;

public class ModelFacade {
	
	private AdministradorDAO admDAO;
	private HombreDAO homDAO;
	private MujerDAO mujDAO;
	
	public ModelFacade() {
	admDAO = new AdministradorDAO();
	homDAO = new HombreDAO();
	mujDAO = new MujerDAO();
	}
	public AdministradorDAO getAdmDAO() {
		return admDAO;
	}
	public void setAdmDAO(AdministradorDAO admDAO) {
		this.admDAO = admDAO;
	}
	public HombreDAO getHomDAO() {
		return homDAO;
	}
	public void setHomDAO(HombreDAO homDAO) {
		this.homDAO = homDAO;
	}
	public MujerDAO getMujDAO() {
		return mujDAO;
	}
	public void setMujDAO(MujerDAO mujDAO) {
		this.mujDAO = mujDAO;
	}
	
	public void cargarPropiedades(Properties prop) {
		admDAO.ponerPropiedades(prop);
		homDAO.ponerPropiedades(prop);
		mujDAO.ponerPropiedades(prop);
	}
	

}
