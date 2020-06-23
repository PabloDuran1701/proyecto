<%-- 
    Document   : popUpRegistrarUsuario
    Created on : 25/03/2020, 05:00:25 PM
    Author     : Chris
--%>

<div class="container container-fluid" id="containerCrearEncuesta">
    <form action="newUser" method="post">
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

                        <!-- Default form register -->

                        <div class="text-center border border-light p-5 " >


                            <div class="form-row mb-4">
                                <div class="col">
                                    <!-- Last name -->
                                    <input type="text" id="defaultRegisterFormLastId" class="form-control"  name="idUsuario" placeholder="Identificacion" required>
                                </div>
                            </div>
                     

                   
                        
                        </div>
                        <!-- Default form register -->
                    </div>
                    <div class="modal-footer">

                        <button  class="btn-light text-left btn btn-primary " id="ButtonCrearEncuesta" onclick="espaciosEnBlanco()" type="submit" style="background-color: #ef384c; color: white">Registrar</button>

                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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
