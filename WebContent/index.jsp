<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dam2.dii.p2.Contacto"%>
	
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Mi agenda</title>
        <link rel="stylesheet" href="resources/css/styles.css">
    </head>
    <body>
        <div class="form-box">
            <div class="button-box">
                <div id="btn"></div>
                <h4 class="toggle-btn">Mi agenda</h4>
            </div>
            <div class="input-group" id="save">
                <form action="<%=request.getContextPath()%>/Controlador" method="post">
                    <input type="text" class="input-field" name="nombre" placeholder="Nombre" required>
                    <input type="text" class="input-field" name="apellido1" placeholder="Primer apellido" required>
                    <input type="text" class="input-field" name="apellido2" placeholder="Segundo apellido" required>
                    <input type="text" class="input-field" name="email" placeholder="Email" required>
                    <input type="text" class="input-field" name="telefono" placeholder="Telefono" required>
                    <input type="text" class="input-field" name="comentarios" placeholder="Comentarios">
                    <input type="submit" class="submit-btn" value="Guardar"/>
                </form>
                <p>${error}</p>
            </div>
            <div class="table-group" id="show">
                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Primer apellido</th>
                        <th>Segundo apellido</th>
                        <th>Email</th>
                        <th>Telefono</th>
                        <th>Comentarios</th>
                    </tr>
                    
                    <% 
                    ArrayList<Contacto> lista_contactos = (ArrayList<Contacto>) request.getAttribute("listado");
                    if(lista_contactos != null){
                    	for(int i=0; i<lista_contactos.size(); i++){ 
                    %>
                    <tr>
	                    <td><%= lista_contactos.get(i).getNombre() %></td> 
	                   	<td><%= lista_contactos.get(i).getApellido1() %></td>
	                   	<td><%= lista_contactos.get(i).getApellido2() %></td>
	                   	<td><%= lista_contactos.get(i).getEmail() %></td>
	                   	<td><%= lista_contactos.get(i).getTelefono() %></td>
	                   	<td><%= lista_contactos.get(i).getComentarios() %></td>
                   	</tr>
                    <%	
                    	}
                    }
                    %>
                    
                </table>
            </div>
        </div>
    </body>
</html>
