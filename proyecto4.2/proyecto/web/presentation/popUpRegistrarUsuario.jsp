<%-- 
// popUpRegistrarUsuario.jsp
//
// EIF209 - Programación 4 ? Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez
//
--%>

<div class="container container-fluid" id="containerCrearEncuesta">
    <form action="newUser" method="post">
        <div class="modal fade" id="registrarUser" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="ModalLabel">Registrar Usuario</h5>
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
                            <div class="form-row mb-4">
                                <div class="col">
                                    <!-- First name -->
                                    <input type="text" id="defaultRegisterFormFirstName" name="nombreUsuario" class="form-control" placeholder="Nombre" required >
                                </div>
                                <div class="col">
                                    <!-- Last name -->
                                    <input type="text" id="defaultRegisterFormLastName1"  name="apellidoUsuario" class="form-control" placeholder="Apellidos" required>
                                </div>
                            </div>

                            <!--Direccion -->
                            <input type="text" id="defaultRegisterFormDireccion" class="form-control mb-4" placeholder="Direccion"  name="Direccion" required >
                            <div class="form-row mb-6">
                                <div class="col">

                                    <!-- Phone number -->
                                    <input type="text" id="defaultRegisterPhonePassword" class="form-control"  name="telUsuario" placeholder="Telefono" aria-describedby="defaultRegisterFormPhoneHelpBlock" required>
                                    <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">

                                    </small>
                                </div>
                            </div>
                            <div class="form-row mb-6">

                                <div class="col">
                                    <!-- Password -->
                                    <input type="password" id="contrasena1Usuario" class="form-control" placeholder="Contraseña"  name="contrasena1Usuario" aria-describedby="defaultRegisterFormPasswordHelpBlock" required="true">
                                    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                                        Minímo 8 caracteres
                                    </small>
                                </div>
                                <div class="col">
                                    <!-- Password -->
                                    <input type="password" id="contrasena2Usuario" class="form-control" placeholder="ConfirmarContraseña"  name="contrasena2Usuario" aria-describedby="defaultRegisterFormPasswordHelpBlock" required="true">
                                    <small id="defaultRegisterFormPasswordHelpBlock2" class="form-text text-muted mb-4">
                                        Minimo 8 caracteres
                                    </small>
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
<script language="javascript" type="text/javascript">
    function espaciosEnBlanco() {
        nombre = document.getElementById("defaultRegisterFormFirstName");
        apellidos = document.getElementById("defaultRegisterFormLastName1");
        cedula = document.getElementById("defaultRegisterFormLastId");
        correo = document.getElementById("defaultRegisterFormEmail");
        contra1 = document.getElementById("contrasena1Usuario");
        contra2 = document.getElementById("contrasena2Usuario");
        var aux = String(nombre.value);
        nombre.value = aux.replace(" ", "");
        aux = String(apellido1.value);
        apellido1.value = aux.replace(" ", "");
        aux = String(apellido2.value);
        apellido2.value = aux.replace(" ", "");
        aux = String(cedula.value);
        cedula.value = aux.replace(" ", "");
        aux = String(correo.value);
        correo.value = aux.replace(" ", "");
        aux = String(contra1.value);
        contra1.value = aux.replace(" ", "");
        aux = String(contra2.value);
        contra2.value = aux.replace(" ", "");
        carga();
        verificarContrasena();
    }


    function Solo_Numerico(variable) {
        Numer = parseInt(variable);
        if (isNaN(Numer)) {
            return "";
        }
        return Numer;
    }
    function ValNumero(Control) {
        Control.value = Solo_Numerico(Control.value);
        Control.placeholder = "Ingrese un numero";
    }
    function validar(e, Control) { // 1
        cambiaHolder(Control);
        tecla = (document.all) ? e.keyCode : e.which; // 2
        if (tecla === 8)
            return true; // 3
        patron = /[A-Za-z\s]/; // 4
        te = String.fromCharCode(tecla); // 5
        return patron.test(te); // 6

    }
    function cambiaHolder(Control) {
        Control.placeholder = "Ingrese Letras";
        //  if (document.Model.encuestaExciste(Control.value.toString())) {
        //      Control.placeholder = "Encuesta ya existe";
        //      Control.value = "";
        //  }
    }
    function carga() {
        control = document.getElementById("cargando");
        control.style = "visibility: visible";
    }
    function cancelaCarga() {
        control = document.getElementById("cargando");
        control.style = "visibility: hidden";
    }
    function verificarContrasena() {
        contra1 = document.getElementById("contrasena1Usuario");
        contra2 = document.getElementById("contrasena2Usuario");
        if (contra1.value === contra2.value) {
            var st = contra1.value;
            if (st.length > 7) {

            } else {
                contra1.value = "";
                contra2.value = "";
                contra1.setAttribute("placeholder", "contraseña muy corta minimo 8 caracteres");
                contra2.setAttribute("placeholder", "contraseña muy corta minimo 8 caracteres");
                cancelaCarga();
            }
        } else {
            contra1.value = "";
            contra2.value = "";
            contra1.setAttribute("placeholder", "contraseña no coincide");
            contra2.setAttribute("placeholder", "contraseña no coincide");
            cancelaCarga();
        }
        verEmail();
        numeroT();
        idValidar();
        if (document.getElementById("defaultRegisterFormFirstName").value === "" || document.getElementById("defaultRegisterFormLastName1").value === "" || document.getElementById("defaultRegisterFormlastName2").value === "") {
            cancelaCarga();
        }
    }


    function numeroT() {
        var campT1 = document.getElementById("defaultRegisterPhonePassword");
        var camp = String(campT1.value);
        if (camp.length !== 8) {
            campT1.value = "";
            cancelaCarga();
        }
        var campT2 = document.getElementById("defaultRegisterPhonePassword2");
        camp = String(campT2.value);
        if (camp !== "") {
            if (camp.length !== 8) {
                campT2.value = "";
                cancelaCarga();
            }
        }
    }
    function idValidar() {
        var campId = document.getElementById("defaultRegisterFormLastId");
        var sCamp = String(campId.value);
        if (sCamp.length === 9) {
            if (sCamp.charAt(0) === "a" || sCamp.charAt(0) === "A" || sCamp.charAt(0) === "1" || sCamp.charAt(0) === "2" || sCamp.charAt(0) === "3" || sCamp.charAt(0) === "4" || sCamp.charAt(0) === "5" ||
                    sCamp.charAt(0) === "6" || sCamp.charAt(0) === "7" || sCamp.charAt(0) === "8" || sCamp.charAt(0) === "9") {
                if (sCamp.charAt(0) === "a") {
                    sCamp = sCamp.replace("a", "A");
                    campId.value = sCamp;
                }
            } else {
                campId.value = "";
                cancelaCarga();
            }
        } else {
            campId.value = "";
            cancelaCarga();
        }
    }

</script>
