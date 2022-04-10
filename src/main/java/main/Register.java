package main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Register", value = "/servlet-register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Leer los campos
        String nombre = request.getParameter("username");
        String email = request.getParameter("email1");
        String contrasena = request.getParameter("password1");
        String telefono = request.getParameter("telefono");
        //Checkear la BD

        /*COSAS QUE BORRAR*/
        System.out.println("email: " + email);
        System.out.println("password: " + contrasena);

        // do some processing here...

        // get response writer
        PrintWriter writer = response.getWriter();

        // build HTML code

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + email + "<br/>";
        htmlRespone += "Your password is: " + contrasena + "</h2>";
        htmlRespone += "</html>";
        // return response
        //writer.println(htmlRespone);
        /*FIN DE COSAS QUE BORRAR*/
        
        response.sendRedirect("/index.html");
        try {
            Class.forName("org.postgresql.Driver");
            try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
                if(connection != null) {
                    Statement st = connection.createStatement();
                    String query = "INSERT INTO usuarios" + " VALUES('" + nombre + "','" + email + "','" + contrasena + "','" + telefono + "');";
                    st.executeUpdate(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
