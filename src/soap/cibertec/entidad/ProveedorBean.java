package soap.cibertec.entidad;

import java.io.Serializable;

public class ProveedorBean implements Serializable {
	
	private int codigo;
	private String nombre;
	private String dni;
	private String telefono;
	private String correo;
	private int codPais;
	
	
	
	public int getCodPais() {
		return codPais;
	}
	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	

}
