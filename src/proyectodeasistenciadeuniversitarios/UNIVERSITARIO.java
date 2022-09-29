/*
        CLASE UNIVERSITARIO, QUE MANIPULA LOS DATOS PERSONALES DEL UNIVERSITARIO
 */
package proyectodeasistenciadeuniversitarios;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class UNIVERSITARIO {
    private int  Codigo;
    private String Nombre;
    private String Apellidos;
    private char Genero;
    private String Cargo;
    private int Edad;

    public UNIVERSITARIO() {
    }

    public UNIVERSITARIO(int Codigo, String Nombre, String Apellidos, char Genero, String Cargo, int Edad) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Genero = Genero;
        this.Cargo = Cargo;
        this.Edad = Edad;
    }
       
    public int getCodigo()
    {
        return Codigo;
    }
    
    public void setCodigo(int codigo)
    {
        this.Codigo=codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    public int getEdad()//añadidos
    {
        return Edad;
    }
    
    public void setEdad(int edad)
    {
        this.Edad=edad;
    }    
  
}