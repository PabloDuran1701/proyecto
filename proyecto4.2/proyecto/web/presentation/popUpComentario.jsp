<%-- 
// popUpComentario.jsp
//
// EIF209 - Programaci�n 4 ? Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez
//
--%>

<div class="container container-fluid" id="containerCrearEncuesta">
    <form action="newComentario" method="post">
        <div class="modal fade" id="comentario" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="ModalLabel">Comentario</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body jumbotron" id="modBody">
                        <div class="text-center border border-light p-5 " >
                            <div class="form-row mb-4">
                                <div class="col">
                                    <input type="text" id="Come" class="form-control"  name="Come" >
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">

                        <button  class="btn-light text-left btn btn-primary " id="CrearComentario" onclick="espaciosEnBlanco()" type="submit" style="background-color: #ef384c; color: white">OK</button>

                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Salir</button>
                        <div id="cargando" style="visibility: hidden" class="spinner-grow text-danger" role="status">
                            <span class="sr-only"></span>
                        </div>
                        <input type="text" name="cbe" style=" display:none;" value="">

                    </div>
                </div>
            </div>

        </div>
    </form>
</div>
