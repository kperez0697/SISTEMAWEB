
package Modelo;


public class Cliente {
    int id;
    String dni;
    String Nombre;
    String direccion;
    

    public Cliente() {
    }

    public Cliente(int id, String dni, String Nombre, String direccion) {
        this.id = id;
        this.dni = dni;
        this.Nombre = Nombre;
        this.direccion = direccion;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
    
    
}
