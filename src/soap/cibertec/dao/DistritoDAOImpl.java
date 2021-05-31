package soap.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import soap.cibertec.entidad.DistritoBean;
import soap.cibertec.interfaces.DistritoDAO;
import utils.MysqlDBConexion;
public class DistritoDAOImpl implements DistritoDAO{

	@Override
	public List<DistritoBean> listAllDistritos() {
		List<DistritoBean> lista=new ArrayList<DistritoBean>();
		DistritoBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_listarDistritos()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new DistritoBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
}

