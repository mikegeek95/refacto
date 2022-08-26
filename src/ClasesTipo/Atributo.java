package ClasesTipo;

public class Atributo {

    private String calificador;
    private String tipo;
    private String nombre;

    public Atributo(String calificador, String tipo, String nombre) {
        this.calificador= calificador;
        this.calificador= tipo;
        this.calificador= nombre;
    }

    public void setCalificador(String valorCalificador) {
        calificador = valorCalificador;
    }

    public String getCalificador() {
        return calificador;
    }

    public void setTipo(String valorTipo) {
        tipo = valorTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String valornombre) {
        nombre = valornombre;
    }

    public String getNombre() {
        return nombre;
    }

}
