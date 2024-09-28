package com.servletjdbc.registrationapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SecondServlet");

        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("UName");
            int age = Integer.parseInt((String) session.getAttribute("UAge"));
            String city = (String) session.getAttribute("UCity");
            String email = (String) session.getAttribute("UEmail");

            PrintWriter writer = response.getWriter();
            writer.println("<h1>Request from second servlet</h1>" + name + " " + age + " " + city + " " + email);
            writer.close();
        }
        else {
            PrintWriter writer = response.getWriter();
            writer.println("<h1>No session available!</h1>");
            writer.close();
        }

//        HttpSession session = request.getSession(false);
//        String name = (String) session.getAttribute("UName");
//        int age = Integer.parseInt(request.getParameter("age"));
//        String city = (String) session.getAttribute("UCity");
//        String email = (String) session.getAttribute("UEmail");
//
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<h1>Request from second servlet</h1>" + name + " " + age + " " + city + " " + email);
//        writer.close();
    }


}