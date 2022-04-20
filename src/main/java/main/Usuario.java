package main;

public class Usuario {
    public String nombre;
    public String email;
    public String contrasena;
    public String telefono;

    public Usuario(String nombre, String email, String contrasena, String telefono){
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }

    public Usuario(String nombre, String email, String contrasena){
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
