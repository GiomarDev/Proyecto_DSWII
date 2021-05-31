package soap.cibertec.servicio;

import java.util.List;

import soap.cibertec.dao.LaboratorioDAOImpl;
import soap.cibertec.dao.MedicamentoDAOImpl;
import soap.cibertec.dao.ProveedorDAOImpl;
import soap.cibertec.dao.TipoMedicamentoDAOImpl;
import soap.cibertec.entidad.LaboratorioBean;
import soap.cibertec.entidad.MedicamentoBean;
import soap.cibertec.entidad.ProveedorBean;
import soap.cibertec.entidad.TipoMedicamentoBean;

public class ServicioMedicamento {

	LaboratorioDAOImpl laboratorioDAO=new LaboratorioDAOImpl();
	TipoMedicamentoDAOImpl tipoMedicamentoDAO=new TipoMedicamentoDAOImpl();
	ProveedorDAOImpl proveedorDAO =new ProveedorDAOImpl();
	MedicamentoDAOImpl medicamentoDAO=new MedicamentoDAOImpl();
	
	public List<LaboratorioBean> listarLaboratorios(){
		return laboratorioDAO.listAllLaboratorios();
	}

	public List<TipoMedicamentoBean> listarTipoMedicamento(){
		return tipoMedicamentoDAO.listAllTipoMedicamentos();
	}
	
	public List<ProveedorBean> listarProveedores(){
		return proveedorDAO.listAllProveedor();
	}
	
	public int registrarMedicamento(MedicamentoBean bean) {
		return medicamentoDAO.saveMedicamento(bean);
	}
	

	public int actualizarMedicamento(MedicamentoBean bean) {
		return medicamentoDAO.updateMedicamento(bean);
	}
	

	public int eliminarMedicamento(int codigo) {
		return medicamentoDAO.deleteMedicamento(codigo);
	}
	
	
	
}
