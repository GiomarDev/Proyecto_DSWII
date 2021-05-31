package soap.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import soap.cibertec.entidad.DocenteBean;
import soap.cibertec.interfaces.DocenteDAO;
import utils.MysqlDBConexion;
public class DocenteDAOImpl implements DocenteDAO{
	@Override
	public int saveDocente(DocenteBean bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_saveDocente(?,?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getNombre());
			cstm.setString(2,bean.getPaterno());
			cstm.setString(3,bean.getMaterno());
			cstm.setString(4,bean.getSexo());
			cstm.setInt(5, bean.getNumHijos());
			cstm.setDouble(6, bean.getSueldo());
			cstm.setString(7, bean.getDireccion());
			cstm.setInt(8, bean.getCodigoDistrito());
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public int updateDocente(DocenteBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_updateDocente(?,?,?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getCodigo());
			cstm.setString(2,bean.getNombre());
			cstm.setString(3,bean.getPaterno());
			cstm.setString(4,bean.getMaterno());
			cstm.setString(5,bean.getSexo());
			cstm.setInt(6, bean.getNumHijos());
			cstm.setDouble(7, bean.getSueldo());
			cstm.setString(8, bean.getDireccion());
			cstm.setInt(9, bean.getCodigoDistrito());
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public int deleteDocente(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_deleteDocente(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public DocenteBean findDocente(int codigo) {
		DocenteBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findDocente(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new DocenteBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPaterno(rs.getString(3));
				bean.setMaterno(rs.getString(4));
				bean.setSexo(rs.getString(5));
				bean.setNumHijos(rs.getInt(6));
				bean.setSueldo(rs.getDouble(7));
				bean.setDireccion(rs.getString(8));
				bean.setCodigoDistrito(rs.getInt(9));
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
		return bean;
	}	
	@Override
	public List<DocenteBean> listAllDocentes(){
		List<DocenteBean> lista=new ArrayList<DocenteBean>();
		DocenteBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_listarDocentes()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new DocenteBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPaterno(rs.getString(3));
				bean.setMaterno(rs.getString(4));
				bean.setSexo(rs.getString(5));
				bean.setNumHijos(rs.getInt(6));
				bean.setSueldo(rs.getDouble(7));
				bean.setDireccion(rs.getString(8));
				bean.setCodigoDistrito(rs.getInt(9));
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
	@Override
	public List<DocenteBean> listAllDocentesXSexo(String sexo) {
		List<DocenteBean> lista=new ArrayList<DocenteBean>();
		DocenteBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findDocente(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, sexo);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new DocenteBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPaterno(rs.getString(3));
				bean.setMaterno(rs.getString(4));
				bean.setSexo(rs.getString(5));
				bean.setNumHijos(rs.getInt(6));
				bean.setSueldo(rs.getDouble(7));
				bean.setDireccion(rs.getString(8));
				bean.setCodigoDistrito(rs.getInt(9));
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


