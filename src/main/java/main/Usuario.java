package main;

public class Usuario {
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    private Integer id;

    public Usuario(String nombre, String email, String contrasena, String telefono, Integer id){
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.id = id;
    }

    public Usuario(String nombre, String email, String contrasena, String telefono){
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.id = -1;
    }

    public Usuario(String nombre, String email, String contrasena){
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = "";
        this.id = -1;
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

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
}
