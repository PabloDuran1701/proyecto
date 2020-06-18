package daos;

public enum IMEC_Pizza {
    INSERTAR("INSERT INTO pizza (nombre, tamano, precio) VALUES (?, ?, ?); "),
    MODIFICAR("UPDATE pizza SET precio = ? WHERE ID=?; "),
    EXCLUIR("DELETE FROM pizza WHERE ID=?; "),
    CONSULTAR("SELECT ID, nombre,tamano,precio FROM pizza WHERE ID=?; "),
    LISTAR("SELECT ID, nombre,tamano,precio FROM pizza; ");

    IMEC_Pizza(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
