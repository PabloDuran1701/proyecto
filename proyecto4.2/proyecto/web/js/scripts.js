
var catalogo = null; // Mantiene el inventario de productos disponible.
var productoSeleccionado = null;
var tablaFactura = [];

var menu = null;

function init() {

    // La función inicializarDatos() ya ha cargado la variable
    // con el catálogo de producos antes de ejecutar la inicialización.
    // Esto garantiza que los datos estén cargados correctamente antes de
    // ejecutar cualquier otro código.

    actualizarTabla();
    console.log("Aplicación inicializada..");
}

function inicializarDatos(nuevosDatos) {

    // Esta función se ejecuta cuando se carga la hoja de scripts.
    // NO se ejecuta como respuesta a un evento de la página.
    // Observe que es posible cargar los datos de manera asíncrona
    // y actualizar el menú de productos cuando el servidor envíe la
    // respuesta a la petición.

    menu = nuevosDatos;
    console.log("Datos cargados..");
}


function actualizarTabla() {
    var pizzas = menu["lista-pizzas"];
    var tblBody = document.getElementById("cuerpo");
    pizzas.forEach(
            function (pizza, i)
       {
                var hilera = document.createElement("tr");
                
                var celda = document.createElement("td");
                var textoCelda = document.createTextNode(" ");
               
                var celda2 = document.createElement("td");
                var textoCelda2 = document.createTextNode(pizza.nombre);
               
                var celda3 = document.createElement("td");
                var textoCelda3 = document.createTextNode(pizza.tamano);
               
                var celda4 = document.createElement("td");
                var textoCelda4 = document.createTextNode(pizza.precio);
                
                var celda5 = document.createElement("td");
                var textoCelda5 = document.createTextNode(" ");
                

               
               
                celda.appendChild(textoCelda);
                hilera.appendChild(celda);
                celda2.appendChild(textoCelda2);
                hilera.appendChild(celda2);
                celda3.appendChild(textoCelda3);
                hilera.appendChild(celda3);
                celda4.appendChild(textoCelda4);
                hilera.appendChild(celda4);
                celda5.appendChild(textoCelda5);
                hilera.appendChild(celda5);

                
                
                tblBody.appendChild(hilera);
            }
    );


}


function Enviar() {
    var datos = new FormData();
    datos.append("items", tablaFactura.length);
    console.log(tablaFactura.length);
    tablaFactura.forEach(
            function (item, i) {
                datos.append("codigo" + i, item.codigo);
                datos.append("cantidad" + i, item.cantidad);
            }
    );
    getJSON('ServicioProductos', datos, mostrarResultados);
}

function getJSON(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);
}

function mostrarResultados(datos) {
    console.log(datos);
    mensaje(JSON.stringify(datos));
}

function mensaje(msj) {

    var dato = JSON.parse(msj);
    if (dato['result'] == "ok") {
        location.reload();
        var refM = document.getElementById('mensaje');
        refM.innerHTML = `${refM.innerHTML}${"Factura Agregada"}<br />`;


    } else {
        var refM = document.getElementById('mensaje');
        refM.innerHTML = `${refM.innerHTML}${"Error"}<br />`;
    }


}