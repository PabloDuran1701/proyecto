<%-- 
// Menu.jsp
//
// EIF209 - Programación 4 ? Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez
//
--%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <%@include file="../presentation/popUpRegistrarUsuario.jsp" %>
    <%@include file="../presentation/popUpAgregarPizza.jsp" %>
    <a class="navbar-brand" href="#">Carrito</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <%@include file="../presentation/popUpComentario.jsp" %>
        
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="../presentation/CrudMenu.jsp">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ConsultarOrden</a>
            </li>
            <li class="nav-item">
                <a data-toggle="modal" class="nav-link" data-target="#comentario" href="#">Comentarios</a>
            </li>
             <li class="nav-item">
                <a class="nav-link" href="../presentation/popUpAgregarPizza.jsp">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Salir</a>
            </li>
        </ul>
    </div>
</nav>