package soap.cibertec.interfaces;

import java.util.List;

import soap.cibertec.entidad.MedicamentoBean;

public interface MedicamentoDAO {
	
	public int saveMedicamento(MedicamentoBean bean);
	public int updateMedicamento(MedicamentoBean bean);
	public int deleteMedicamento(int codigo);
	public MedicamentoBean findMedicamentos(int codigo);
	public List<MedicamentoBean> listAllMedicamentos();
	public List<MedicamentoBean> listAllMedicamentosXNombre(String nombre);

}
