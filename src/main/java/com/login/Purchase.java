package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Purchase extends HttpServlet {
    Connection conn;
    

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       
        String accname = request.getParameter("accname");
        String cvv = request.getParameter("cvv");
        String accno = request.getParameter("accno");   
        String pid = request.getParameter("details");
        String email=Cookiecls.email;
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
//            while(rs.next()) {
//                if(email.equals(rs.getString("email"))) {
//                    usrExists = true;
//                    request.setAttribute("invalid", "Existing Email Id!! ");
//        			RequestDispatcher rd = request.getRequestDispatcher("regis.jsp");
//        			rd.forward(request, response);
//                    break;
//                }
//            }
            String query = "insert into purchase(email, product_id, name, account_no, cvv) values(?, ?, ?, ?, ?)";
            PreparedStatement pStatement = conn.prepareStatement(query);
            pStatement.setString(1, email);
            pStatement.setString(2, pid);
            pStatement.setString(3, accname);
            pStatement.setString(4, accno);
            pStatement.setString(5,cvv);
            pStatement.execute();
            pStatement.clearParameters();
            out.println("<h1>Purchased Successfully!</h1>");
           // response.sendRedirect("home.jsp");
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
