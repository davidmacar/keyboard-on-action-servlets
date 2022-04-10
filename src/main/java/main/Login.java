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
        //Leer los campos
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        /*BORRAR*/
        //Checkear la BD
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        // do some processing here...

        // get response writer
        PrintWriter writer = response.getWriter();

        // build HTML code

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + email + "<br/>";
        htmlRespone += "Your password is: " + password + "</h2>";
        htmlRespone += "</html>";
        // return response
        //writer.println(htmlRespone);
        /*FIN BORRADO*/


        try {
            Class.forName("org.postgresql.Driver");
            try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
                if(connection != null){
                    System.out.println("Conectado");
                }
                else{
                    System.out.println("No conectado");
                }
                assert connection != null;
                Statement st = connection.createStatement();
                String query = "SELECT nombre, correo, contrasena FROM usuarios WHERE correo='" + email + "';";
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    if(password.equals(rs.getString("contrasena"))) {
                        System.out.println("Usuario encontrado");
                        HttpSession session = request.getSession();
                        session.setAttribute("username", rs.getString("nombre"));
                        session.setAttribute("email", rs.getString("correo"));
                        session.setAttribute("contrasena", rs.getString("contrasena"));

                    }
                    else
                        System.out.println("Usuario no encontrado");
                }
                response.sendRedirect("/paginas/usuarios/login.html");
            } catch (SQLException e) {
                e.printStackTrace();
            } ;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
