package soap.cibertec.servicio;

import java.util.List;

import soap.cibertec.dao.PaisDAOImpl;
import soap.cibertec.dao.ProveedorDAOImpl;
import soap.cibertec.entidad.PaisBean;
import soap.cibertec.entidad.ProveedorBean;

public class servicioProveedor {
	
	PaisDAOImpl paisDAO=new PaisDAOImpl();
	ProveedorDAOImpl proveedorDAO= new ProveedorDAOImpl();
	
	public List<PaisBean>listarPaises(){
		return paisDAO.lisAllPaises();
	}
	
	public int registrar(ProveedorBean bean) {
		return proveedorDAO.saveProveedor(bean);
	}
	
	public int actualizar(ProveedorBean bean) {
		return proveedorDAO.updateProveedor(bean);
	}
	
	public int eliminar(int codigo) {
		return proveedorDAO.deleteProveedor(codigo);
	}
	
	public List<ProveedorBean>listarPorNombre(String nombre){
		return proveedorDAO.listAllProveedorxNombre(nombre);
	}
	
	

}
