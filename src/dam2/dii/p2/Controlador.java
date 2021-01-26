package dam2.dii.p2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

	ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String comentarios = request.getParameter("comentarios");

		Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telefono, comentarios);
		String mensaje = "";
		boolean existe = existeUsuario(email);

		if (existe) {
			mensaje = "El usuario ya existe";
		} else {
			listaContactos.add(contacto);
			mensaje = "Anadido con exito";
		}

		request.setAttribute("error", mensaje);
		request.setAttribute("listado", listaContactos);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	private boolean existeUsuario(String email) {
		boolean resultado = false;

		for (int i = 0; i < listaContactos.size(); i++) {
			Contacto contacto = listaContactos.get(i);
			String emailContacto = contacto.getEmail();
			
			if (emailContacto.equals(email)) {
				resultado = true;
			}
		}

		return resultado;
	}
}
