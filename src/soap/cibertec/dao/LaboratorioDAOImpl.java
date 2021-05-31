package soap.cibertec.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import soap.cibertec.entidad.LaboratorioBean;
import soap.cibertec.interfaces.LaboratorioDAO;
import utils.MysqlDBConexion;

public class LaboratorioDAOImpl implements LaboratorioDAO {

	@Override
	public List<LaboratorioBean> listAllLaboratorios() {
		List<LaboratorioBean> lista=new ArrayList<LaboratorioBean>();
		LaboratorioBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_listarLaboratorios()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new LaboratorioBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setDireccion(rs.getString(3));
				lista.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
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
