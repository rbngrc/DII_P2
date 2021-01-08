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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlador(request, response, listaContactos);
	}
	
	public void controlador(HttpServletRequest request, HttpServletResponse response, ArrayList<Contacto> listaContactos) throws ServletException, IOException {
		
		guardarContacto(request, response);
			
	}
	
	private ArrayList<Contacto> guardarContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String comentarios = request.getParameter("comentarios");
		boolean existe = false;

		Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telefono, comentarios);
		
		listaContactos.add(contacto);
		
		for (int i = 0; i < listaContactos.size(); i++) {
			existe = false;
			for (int j = 0; !existe && j < i; j++) {
				Contacto cont = listaContactos.get(j);
				String contenido = cont.getEmail();
				if (contenido.equals(email)) {
					   request.setAttribute("error", "Ya existe un usuario con ese email");
					   listaContactos.remove( listaContactos.size() - 1);
					   mostrarContacto(request, response, listaContactos);
					   existe = true;
				} 
			}
			if (!existe){
				mostrarContacto(request, response, listaContactos);
				request.setAttribute("error", "");
			}
		}
		
		return listaContactos;
		
	}
	
	private void mostrarContacto(HttpServletRequest request, HttpServletResponse response, ArrayList<Contacto> listaContactos) throws ServletException, IOException {
		request.setAttribute("listado", listaContactos);

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
