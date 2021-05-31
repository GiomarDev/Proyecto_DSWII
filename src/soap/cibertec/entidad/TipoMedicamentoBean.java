package soap.cibertec.entidad;

import java.io.Serializable;

public class TipoMedicamentoBean implements Serializable {
	
	private int codigo;
	private String nombre;
	private int idLaboratorio;
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdLaboratorio() {
		return idLaboratorio;
	}
	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
	
	
	

}
