package entidades;
//hola el santi trabajo aqui
// hola yo trabaje andres
public class Estudiante {

    private String nombre;
    private String apellido;
    private int edad;
    private String identificacion;
    private String curso;
    private double montoMatricula;
    private double montoPension;
    private double montoMatriculaPagado;
    private double montoPensionPagado;

    public Estudiante(String nombre, String apellido, int edad, String identificacion, String curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.identificacion = identificacion;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getMontoMatricula() {
        return montoMatricula;
    }

    public void setMontoMatricula(double montoMatricula) {
        this.montoMatricula = montoMatricula;
    }

    public double getMontoPension() {
        return montoPension;
    }

    public void setMontoPension(double montoPension) {
        this.montoPension = montoPension;
    }

    public double getMontoMatriculaPagado() {
        return montoMatriculaPagado;
    }

    public void setMontoMatriculaPagado(double montoMatriculaPagado) {
        this.montoMatriculaPagado = montoMatriculaPagado;
    }

    public double getMontoPensionPagado() {
        return montoPensionPagado;
    }

    public void setMontoPensionPagado(double montoPensionPagado) {
        this.montoPensionPagado = montoPensionPagado;
    }
    public boolean haPagadoCuotas() {
        return montoMatricula > 0 || montoPension > 0;
    }
}
