package soap.cibertec.interfaces;
import java.util.List;
import soap.cibertec.entidad.DocenteBean;
public interface DocenteDAO {
	public int saveDocente(DocenteBean bean);
	public int updateDocente(DocenteBean bean);
	public int deleteDocente(int codigo);
	public DocenteBean findDocente(int codigo);
	public List<DocenteBean> listAllDocentes();
	public List<DocenteBean> listAllDocentesXSexo(String sexo);
}

