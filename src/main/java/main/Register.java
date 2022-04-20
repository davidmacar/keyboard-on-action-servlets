package main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.*;

@WebServlet(name = "Register", value = "/servlet-register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter respuesta = response.getWriter();
        //Leer los campos
        String nombre = request.getParameter("username");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String contrasena1 = request.getParameter("password1");
        String contrasena2 = request.getParameter("password2");
        String telefono = request.getParameter("telefono");

        //System.out.println("Nombre: " + nombre + "\nemail1: " + email1 + "\nemail2: " + email2 + "\ncontrasena1: "
        //        + contrasena1 + "\ncontrasena2: " + contrasena2 + "\ntelefono: " + telefono);
        /*COMPROBACIONES DE CAMPOS*/
        if (!nombre.equals("")){
            if (!email1.equals("")) {
                if (!email2.equals("")){
                    if(email1.equals(email2)) {
                        if (!contrasena1.equals("")) {
                            if (!contrasena2.equals("")){
                                if(contrasena1.equals(contrasena2)) {
                                    if (!telefono.equals("")) {
                                        try {
                                            double d = Double.parseDouble(telefono);
                                        } catch (NumberFormatException err) {
                                            telefono = "-1";
                                        }
                                    }
                                    Usuario usuario = new Usuario(nombre, email1, contrasena1, telefono);
                                    try {
                                        Class.forName("org.postgresql.Driver");
                                        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
                                            if (connection != null) {
                                                Statement st = connection.createStatement();
                                                String query = "INSERT INTO usuarios" + " VALUES('" + usuario.getNombre() + "','" + usuario.getEmail() + "','" + usuario.getContrasena() + "','" + usuario.getTelefono() + "');";
                                                st.executeUpdate(query);

                                                Statement stmt = connection.createStatement();
                                                ResultSet rs = stmt.executeQuery("SELECT \"ID\", \"Nombre\", \"Email\", \"Contrasena\", \"Telefono\" FROM usuarios WHERE \"Email\"='" + email1 + "';");
                                                while(rs.next()){
                                                    //Display values
                                                    usuario = new Usuario(rs.getString("Nombre"), rs.getString("Email"),
                                                            rs.getString("Contrasena"), String.valueOf(rs.getLong("Telefono")), rs.getInt("ID") );
                                                    System.out.println("Usuario registrado y recuperado:\nNombre: " + usuario.getNombre() + "\nEmail: " + usuario.getEmail() + "\nContraseña: "
                                                            + usuario.getContrasena() + "\nTelefono: " + usuario.getTelefono() + "\nID: " + usuario.getId());
                                                    respuesta.println("OK,correcto,"+usuario.getNombre()+","+usuario.getEmail()+","+usuario.getId());

                                                }
                                            }

                                        } catch (SQLException e) {
                                            if (e.getSQLState().equals("23505")) {//Error de duplicado en la BD
                                                System.out.println("Usuario duplicado");
                                                respuesta.println("ERROR,duplicado");
                                            } else {
                                                e.printStackTrace();
                                                System.out.println("ERROR: " + e.getErrorCode());
                                                respuesta.println("ERROR,otro");
                                            }

                                        }
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                } else{//contrasena1 != contrasena2
                                    respuesta.println("ERROR,contrasenas");
                                }
                            } else{//Falta contrasena2
                                respuesta.println("ERROR,contrasena2");
                            }
                        } else{//Falta contrasena1
                            respuesta.println("ERROR,contrasena1");
                        }
                    } else{//email1 != email2
                        respuesta.println("ERROR,emails");
                    }
                } else{//Falta email2
                    respuesta.println("ERROR,email2");
                }
            } else{ //Falta email1
                respuesta.println("ERROR,email1");
            }
        }
        else{//Falta nombre
            respuesta.println("ERROR,nombre");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
