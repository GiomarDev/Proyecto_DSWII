package soap.cibertec.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import soap.cibertec.entidad.DocenteBean;
import soap.cibertec.entidad.ProveedorBean;
import soap.cibertec.interfaces.ProveedorDAO;
import utils.MysqlDBConexion;

public class ProveedorDAOImpl implements ProveedorDAO {

	@Override
	public int saveProveedor(ProveedorBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_saveProveedor(?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getNombre());
			cstm.setString(2,bean.getDni());
			cstm.setString(3,bean.getTelefono());
			cstm.setString(4,bean.getCorreo());
			cstm.setInt(5, bean.getCodPais());
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
	public int updateProveedor(ProveedorBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_updateProveedor(?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getCodigo());
			cstm.setString(2,bean.getNombre());
			cstm.setString(3,bean.getDni());
			cstm.setString(4,bean.getTelefono());
			cstm.setString(5,bean.getCorreo());
			cstm.setInt(6, bean.getCodPais());
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
	public int deleteProveedor(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_deleteProveedor(?)";
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
	public ProveedorBean findProveedor(int codigo) {
		ProveedorBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findProveedor(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new ProveedorBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setDni(rs.getString(3));
				bean.setTelefono(rs.getString(4));
				bean.setCorreo(rs.getString(5));
				bean.setCodPais(rs.getInt(6));
				;
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
	public List<ProveedorBean> listAllProveedor() {
		List<ProveedorBean> lista=new ArrayList<ProveedorBean>();
		ProveedorBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_listarProveedor()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new ProveedorBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setDni(rs.getString(3));
				bean.setTelefono(rs.getString(4));
				bean.setCorreo(rs.getString(5));
				bean.setCodPais(rs.getInt(6));
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
	public List<ProveedorBean> listAllProveedorxNombre(String nombre) {
		List<ProveedorBean> lista=new ArrayList<ProveedorBean>();
		ProveedorBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findProveedorxNombre(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, nombre);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new ProveedorBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setDni(rs.getString(3));
				bean.setTelefono(rs.getString(4));
				bean.setCorreo(rs.getString(5));
				bean.setCodPais(rs.getInt(6));
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
