
<!--
// Script.js
//
// EIF209 - Programación 4 – Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez
//
-->

var catalogo = null; // Mantiene el inventario de productos disponible.
var productoSeleccionado = null;
var tablaproducto = [];

var menu = null;
var productos=null;

function init() {

    // La función inicializarDatos() ya ha cargado la variable
    // con el catálogo de producos antes de ejecutar la inicialización.
    // Esto garantiza que los datos estén cargados correctamente antes de
    // ejecutar cualquier otro código.

    actualizarTabla();
    actualizarTablaP();
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

function inicializarProductos(produc){
productos=produc;
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

 

                var btn = document.createElement("BUTTON");
                btn.className = "btn";
                btn.innerHTML = "<i class='material-icons' onclick='agregar(" + pizza.id + ");'>delete</i>";

 

                celda.appendChild(textoCelda);
                hilera.appendChild(celda);
                celda2.appendChild(textoCelda2);
                hilera.appendChild(celda2);
                celda3.appendChild(textoCelda3);
                hilera.appendChild(celda3);
                celda4.appendChild(textoCelda4);
                hilera.appendChild(celda4);
                celda5.appendChild(btn);
                hilera.appendChild(celda5);

                tblBody.appendChild(hilera);
            }
    );


}

function actualizarTablaP() {
    var produc = productos["lista-productos"];
    var tblBody = document.getElementById("cuerpoP");
    produc.forEach(
            function (pro, i)
            {
                var hilera = document.createElement("tr");
                
                var celda2 = document.createElement("td");
                var textoCelda2 = document.createTextNode(pro.nombre);

                var celda4 = document.createElement("td");
                var textoCelda4 = document.createTextNode(pro.precio);

                var celda5 = document.createElement("td");

                var btn = document.createElement("BUTTON");
                btn.className = "btn";
                btn.innerHTML = "<i class='material-icons' onclick='agregar(" + pro.id + ");'>delete</i>";


                celda2.appendChild(textoCelda2);
                hilera.appendChild(celda2);
                celda4.appendChild(textoCelda4);
                hilera.appendChild(celda4);
                celda5.appendChild(btn);
                hilera.appendChild(celda5);



                tblBody.appendChild(hilera);
            }
    );

}





function agregar(id) {

    var datospizza = {
        codigo: id,
        cantidad: 1,
        
    };


    var bandera = true;
    tablaproducto.forEach(
            function (item, i) {
                if (item.codigo == id) {
                    item.cantidad = item.cantidad + 1;
                    bandera = false;
                }
            }
    );
    if (bandera) {
        tablaproducto.push(datospizza);
    }

    console.log("Agregando producto: " + JSON.stringify(tablaproducto));
    

//        // Se agrega una fila a la tabla con la información del nuevo producto
//        // seleccionado, y se recalculan los totales de la factura.
//
//        var indice = refTabla.rows.length;
//        var nuevaFila = refTabla.insertRow(-1);
//        var nuevaCelda;
//
//        nuevaCelda = nuevaFila.insertCell(-1);
//        nuevaCelda.innerText = nuevoProducto.codigo;
//        nuevaCelda = nuevaFila.insertCell(-1);
//        nuevaCelda.innerText = nuevoProducto["descripción"];
//
//        nuevaCelda = nuevaFila.insertCell(-1);
//        nuevaCelda.className = "c2";
//        nuevaCelda.innerText = formatoMoneda(datosProducto.precio);
//
//        // La cantidad del producto se muestra en un campo editable.
//        // El atributo 'indice' sirve para identificar a cuál
//        // producto se refiere el campo, por medio de la posición
//        // en la tabla de productos.
//
//        nuevaCelda = nuevaFila.insertCell(-1);
//        var campo = document.createElement("INPUT");
//
//        campo.setAttribute("type", "number");
//        campo.setAttribute("min", 0.0);
//        campo.setAttribute("max", 1000.0);
//
//        campo.setAttribute("indice", indice);
//        campo.value = datosProducto.cantidad;
//        campo.onchange = actualizarCampo;
//        nuevaCelda.appendChild(campo);
//
//        // El valor del subtotal debe tener un atributo 'id', para poder
//        // referenciarlo cuando se actualiza la cantidad.
//
//        nuevaCelda = nuevaFila.insertCell(-1);
//        nuevaCelda.id = "total" + String(indice);
//        nuevaCelda.className = "c2";
//        nuevaCelda.innerText = formatoMoneda(datosProducto.subtotal);
//
//        // Por último, se coloca un botón para indicar cuando una fila
//        // debe eliminarse. Observe que el atributo 'indice' es asignado
//        // al botón, pero el evento es manejado por el icono asignado.
//
//        nuevaCelda = nuevaFila.insertCell(-1);
//        nuevaCelda.className = "c3";
//
//        var btn = document.createElement("BUTTON");
//        btn.className = "btn";
//        btn.setAttribute("indice", indice);
//        btn.innerHTML = "<i class='material-icons' onclick='eliminarFila();'>delete</i>";
//
//        nuevaCelda.appendChild(btn);
//
//        // Ya se ha incluido el producto, por lo que hay que recalcular
//        // los subtotales y el total general.
//
//        actualizarTabla();
//
//        actualizarMenu();
//        actualizarCodigo();
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