package daos;

public enum IMEC_Usuario {
    INSERTAR("INSERT INTO usuario (id, tipo, password, nombre, "
            + "apellido1, direccion, telefono) VALUES (?,?,?,?,?,?,?); "),
    MODIFICAR("UPDATE usuario SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM usuario WHERE id=?; "),
    CONSULTAR("SELECT id, tipo, password, nombre, apellido1, direccion, telefono FROM usuario WHERE id=?; "),
    LISTAR("SELECT id, tipo, password, nombre, apellido1, direccion, telefono FROM usuario; ");

    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
