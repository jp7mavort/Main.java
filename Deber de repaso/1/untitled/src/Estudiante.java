
public class Estudiante {
    public String cedula;
    public String nombre;
    public String apellido;
    public int edad;

    public Estudiante(String cedula, String nombre, String apellido, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cédula: " + cedula + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad;
    }
}