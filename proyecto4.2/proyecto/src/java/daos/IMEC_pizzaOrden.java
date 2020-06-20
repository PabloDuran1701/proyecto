package daos;

public enum IMEC_pizzaOrden {
    INSERTAR("INSERT INTO relacion_pizza_orden (orden,pizza,cantidad) VALUES (?, ?, ?); "),
    //MODIFICAR("UPDATE relacion_pizza_orden SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    //CONSULTAR("SELECT id, apellidos, nombre FROM estudiante WHERE id=?; "),
    LISTAR("SELECT orden FROM relacion_pizza_orden WHERE orden = ? ; ");

    IMEC_pizzaOrden(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
