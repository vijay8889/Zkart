package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String username = request.getParameter("username");
        Cookiecls.name =username;
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Cookiecls.email=email;
        String address = request.getParameter("address");   
        String phno = request.getParameter("phno");
        try {
            String url="jdbc:postgresql://localhost:5432/postgres";
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            conn = DriverManager.getConnection(url, "postgres", "postgres");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select email from users");
            boolean usrExists = false;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            while(rs.next()) {
                if(email.equals(rs.getString("email"))) {
                    usrExists = true;
                    request.setAttribute("invalid", "Existing Email Id!! ");
        			RequestDispatcher rd = request.getRequestDispatcher("regis.jsp");
        			rd.forward(request, response);
                    break;
                }
            }
            String query = "insert into users(username, password, email, address, ph_no) values(?, ?, ?, ?, ?)";
            PreparedStatement pStatement = conn.prepareStatement(query);
            pStatement.setString(1, username);
            pStatement.setString(2, password);
            pStatement.setString(3, email);
            pStatement.setString(4, address);
            pStatement.setInt(5, Integer.parseInt(phno));
            pStatement.execute();
            pStatement.clearParameters();
            //out.println("<h1>Registered Successfully!</h1>");
            response.sendRedirect("home.jsp");
          //  pStatement.close();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }   
}