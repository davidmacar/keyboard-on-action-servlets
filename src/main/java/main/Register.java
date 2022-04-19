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
        String contrasena2 = request.getParameter("password1");
        String telefono = request.getParameter("telefono");

        /*COMPROBACIONES DE CAMPOS*/
        if (nombre != null){
            if (email1 != null) {
                if (email2 != null){
                    if(email1.equals(email2)) {
                        if (contrasena1 != null) {
                            if (contrasena2 != null){
                                if(contrasena1.equals(contrasena2)) {
                                    if (telefono != null) {
                                        try {
                                            double d = Double.parseDouble(telefono);
                                        } catch (NumberFormatException err) {
                                            telefono = "-1";
                                        }
                                    }
                                    try {
                                        Class.forName("org.postgresql.Driver");
                                        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
                                            if (connection != null) {
                                                Statement st = connection.createStatement();
                                                String query = "INSERT INTO usuarios" + " VALUES('" + nombre + "','" + email1 + "','" + contrasena1 + "','" + telefono + "');";
                                                st.executeUpdate(query);
                                                System.out.println("Usuario registrado: \nemail: " + email1 + "\npassword: " + contrasena1);
                                                respuesta.println("OK,correcto");
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
        /*FIN DE COSAS QUE BORRAR*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
