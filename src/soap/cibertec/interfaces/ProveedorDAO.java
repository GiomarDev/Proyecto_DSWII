package soap.cibertec.interfaces;

import java.util.List;

import soap.cibertec.entidad.ProveedorBean;

public interface ProveedorDAO {
	
	public int saveProveedor(ProveedorBean bean);
	public int updateProveedor(ProveedorBean bean);
	public int deleteProveedor(int codigo);
	public ProveedorBean findProveedor(int codigo);
	public List<ProveedorBean> listAllProveedor();
	public List<ProveedorBean> listAllProveedor(String nombre);

}
