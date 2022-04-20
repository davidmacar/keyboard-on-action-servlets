package main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Login", value = "/servlet-login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter respuesta = response.getWriter();
        //Leer los campos
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //System.out.println("Email: " + email + "\nPassword: " + password );
        /*COMPROBACIONES DE CAMPOS*/
        if (!email.equals("")){
            if (!password.equals("")) {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
                        if (connection != null) {
                           Statement stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT \"ID\", \"Nombre\", \"Email\", \"Contrasena\", \"Telefono\" FROM usuarios WHERE \"Email\"='" + email + "';");
                            if(rs.next()){
                                do{
                                    //Display values
                                    Usuario usuario = new Usuario(rs.getString("Nombre"), rs.getString("Email"),
                                            rs.getString("Contrasena"), String.valueOf(rs.getLong("Telefono")), rs.getInt("ID") );
                                    System.out.println("Usuario logeado:\nNombre: " + usuario.getNombre() + "\nEmail: " + usuario.getEmail() + "\nContraseña: "
                                            + usuario.getContrasena() + "\nTelefono: " + usuario.getTelefono() + "\nID: " + usuario.getId());
                                    respuesta.println("OK,correcto,"+usuario.getNombre());
                                }
                                while(rs.next());
                            }
                            else{
                                respuesta.println("ERROR,noExiste");
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

            } else{ //Falta password
                respuesta.println("ERROR,password");
            }
        }
        else{//Falta email
            respuesta.println("ERROR,email");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
