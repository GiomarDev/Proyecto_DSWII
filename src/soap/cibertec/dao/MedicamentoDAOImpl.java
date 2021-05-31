package soap.cibertec.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import soap.cibertec.entidad.MedicamentoBean;
import soap.cibertec.interfaces.MedicamentoDAO;
import utils.MysqlDBConexion;

public class MedicamentoDAOImpl implements MedicamentoDAO {

	@Override
	public int saveMedicamento(MedicamentoBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_saveMedicamento(?,?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getNombre());
			cstm.setString(2,bean.getDescripcion());
			cstm.setInt(3,bean.getStock());
			cstm.setDouble(4,bean.getPrecio());
			cstm.setDate(5, bean.getFecha());
			cstm.setInt(6, bean.getIdLaboratorio());
			cstm.setInt(7, bean.getIdTipoMedicamento());
			cstm.setInt(8, bean.getIdProveedor());
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
	public int updateMedicamento(MedicamentoBean bean) {
		
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_updateMedicamento(?,?,?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getCodigo());
			cstm.setString(2,bean.getNombre());
			cstm.setString(3,bean.getDescripcion());
			cstm.setInt(4,bean.getStock());
			cstm.setDouble(5,bean.getPrecio());
			cstm.setDate(6, bean.getFecha());
			cstm.setInt(7, bean.getIdLaboratorio());
			cstm.setInt(8, bean.getIdTipoMedicamento());
			cstm.setInt(9, bean.getIdProveedor());
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
	public int deleteMedicamento(int codigo) {
		
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_deleteMedicamento(?)";
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
	public MedicamentoBean findMedicamentos(int codigo) {
		MedicamentoBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findMedicamento(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new MedicamentoBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setDescripcion(rs.getString(3));
				bean.setStock(rs.getInt(4));
				bean.setPrecio(rs.getDouble(5));
				bean.setFecha(rs.getDate(6));
				bean.setIdLaboratorio(rs.getInt(7));
				bean.setIdTipoMedicamento(rs.getInt(8));
				bean.setIdProveedor(rs.getInt(9));
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
	public List<MedicamentoBean> listAllMedicamentos() {
		List<MedicamentoBean> lista=new ArrayList<MedicamentoBean>();
		MedicamentoBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_listaMedicamentos()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new MedicamentoBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setDescripcion(rs.getString(3));
				bean.setStock(rs.getInt(4));
				bean.setPrecio(rs.getDouble(5));
				bean.setFecha(rs.getDate(6));
				bean.setIdLaboratorio(rs.getInt(7));
				bean.setIdTipoMedicamento(rs.getInt(8));
				bean.setIdProveedor(rs.getInt(9));
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
	public List<MedicamentoBean> listAllMedicamentosXNombre(String nombre) {
		
		List<MedicamentoBean> lista=new ArrayList<MedicamentoBean>();
		MedicamentoBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findNombreMedicamento(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, nombre);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new MedicamentoBean();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setDescripcion(rs.getString(3));
				bean.setStock(rs.getInt(4));
				bean.setPrecio(rs.getDouble(5));
				bean.setFecha(rs.getDate(6));
				bean.setIdLaboratorio(rs.getInt(7));
				bean.setIdTipoMedicamento(rs.getInt(8));
				bean.setIdProveedor(rs.getInt(9));
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


















