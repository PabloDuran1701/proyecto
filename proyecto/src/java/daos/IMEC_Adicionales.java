package daos;

public enum IMEC_Adicionales {
    INSERTAR("INSERT INTO adicionales (ingredientes,pizza,orden) VALUES (?, ?, ?); "),
    MODIFICAR("UPDATE adicionales SET ingredientes=? WHERE pizza=?; "),
    EXCLUIR("DELETE FROM adicionales WHERE pizza=? and ingredietnes =? ; "),
    //CONSULTAR("SELECT id, apellidos, nombre FROM estudiante WHERE id=?; "),
    LISTAR("select ID, nombre, precio from ingredientes }"
            + "where ID IN(\n" +
            "select ingredientes from adicionales \n" +
            "where pizza = ? \n" +
            "); ");

    IMEC_Adicionales(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
