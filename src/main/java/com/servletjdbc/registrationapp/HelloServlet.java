package com.servletjdbc.registrationapp;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ServletJDBC")
public class HelloServlet extends HttpServlet {


    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("UName");
        String age = request.getParameter("UAge");
        String city = request.getParameter("UCity");
        String email = request.getParameter("UEmail");
        String pswd = request.getParameter("UPswd");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ServletJDBC";
            String user = "root";
            String password = "2408";

            Connection connect = DriverManager.getConnection(url, user, password);


            PreparedStatement pstm = connect.prepareStatement("Insert into RegistrationDetails(SName, SCity, SAge, SEmail, SPass) values(?,?,?,?,?)");
            pstm.setString(1, name);
            pstm.setString(2, city);
            pstm.setString(3, age);
            pstm.setString(4, email);
            pstm.setString(5, pswd);

            int rowAffected = pstm.executeUpdate();
            PrintWriter result = response.getWriter();
            if(rowAffected > 0)
            {
                result.println("<h1>Insertion successful</h1>");
            }
            else {
                result.println("Insertion Failed");
            }
            connect.close();
            pstm.close();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher RequestDispatch = request.getRequestDispatcher("/SecondServlet");
        HttpSession session = request.getSession();
        session.setAttribute("UName", name);
        session.setAttribute("UAge", age);
        session.setAttribute("UCity", city);
        session.setAttribute("UEmail", email);
        RequestDispatch.include(request, response);
//        RequestDispatch.forward(request, response);
    }

}