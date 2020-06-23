package daos;

public enum IMEC_Comentarios {
    INSERTAR("INSERT INTO Comentarios (comentario) VALUES (?); "),
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    //EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    //CONSULTAR("SELECT id, apellidos, nombre FROM estudiante WHERE id=?; "),
    LISTAR("SELECT id, apellidos, nombre FROM estudiante ORDER BY apellidos; ");
    
    IMEC_Comentarios(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
