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
        response.sendRedirect("/index.html");
        try {
            movidas();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void movidas() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usuarios", "postgres", "postgres")) {
            if(connection != null){
                System.out.println("Conectado");
            }
            else{
                System.out.println("No conectado");
            }
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from Usuarios");
            while(rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;

    }
}
