package soap.cibertec.entidad;

import java.io.Serializable;
import java.sql.Date;

public class MedicamentoBean implements Serializable{

	private int codigo;
	private String nombre;
	private String descripcion;
	private int stock;
	private double precio;
	private Date fecha;
	private int idLaboratorio;
	private int idTipoMedicamento;
	private int idProveedor;
	
	
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdLaboratorio() {
		return idLaboratorio;
	}
	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
	public int getIdTipoMedicamento() {
		return idTipoMedicamento;
	}
	public void setIdTipoMedicamento(int idTipoMedicamento) {
		this.idTipoMedicamento = idTipoMedicamento;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
	
	
}
