package dam2.dii.p2;

public class Contacto {

	String nombre;
	String apellido1;
	String apellido2;
	String email;
	String telefono;
	String Comentarios;

	public Contacto(String nombre, String apellido1, String apellido2, String email, String telefono,
			String comentarios) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		Comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}

}
