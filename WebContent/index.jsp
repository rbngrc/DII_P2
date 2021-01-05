<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
                <button type="button" class="toggle-btn" onclick="save()">Anadir</button>
                <button type="button" class="toggle-btn" onclick="show()">Agenda</button>
            </div>
            <form action="" class="input-group" id="save">
                <input type="text" class="input-field" placeholder="Nombre" required>
                <input type="text" class="input-field" placeholder="Primer apellido" required>
                <input type="text" class="input-field" placeholder="Segundo apellido" required>
                <input type="text" class="input-field" placeholder="Email" required>
                <input type="text" class="input-field" placeholder="Telefono" required>
                <input type="text" class="input-field" placeholder="Comentarios" required>
                <button type="submit" class="submit-btn">Guardar</button>
            </form>
            <form action="" class="input-group" id="show">
                <input type="text" class="input-field" placeholder="Nombre" required>
                <input type="text" class="input-field" placeholder="Primer apellido" required>
                <input type="text" class="input-field" placeholder="Segundo apellido" required>
                <input type="text" class="input-field" placeholder="Email" required>
                <input type="text" class="input-field" placeholder="Telefono" required>
                <input type="text" class="input-field" placeholder="Comentarios" required>
            </form>
        </div>

        <script>
            var x = document.getElementById("save");
            var y = document.getElementById("show");
            var z = document.getElementById("btn");

            function show(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }

            function save(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }

        </script>

    </body>
</html>
