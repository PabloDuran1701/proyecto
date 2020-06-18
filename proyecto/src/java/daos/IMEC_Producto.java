package daos;

public enum IMEC_Producto {
    INSERTAR("INSERT INTO producto (nombre,precio,descripcion) VALUES (?, ?, ?); "),
    MODIFICAR("UPDATE producto SET precio=?, descripcion=? WHERE ID=?; "),
    EXCLUIR("DELETE FROM producto WHERE ID=?; "),
    CONSULTAR("SELECT ID,nombre,precio,descripcion FROM producto WHERE ID=?; "),
    LISTAR("SELECT id, nombre,precio,descripcion FROM producto; ");

    IMEC_Producto(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
