package daos;

public enum IMEC_Orden {
    INSERTAR("INSERT INTO orden (id,fecha,estado,usuario) VALUES (?, ?, ?, ?); "),
    //MODIFICAR("UPDATE orden SET estado=? WHERE id=?; "),
    EXCLUIR("DELETE FROM orden WHERE id=?; "),
    CONSULTAR("SELECT id, fecha, estado,usuario FROM orden WHERE id=?; "),
    LISTAR("SELECT id, fecha, estado,usuario FROM orden ORDER BY id; ");

    IMEC_Orden(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
