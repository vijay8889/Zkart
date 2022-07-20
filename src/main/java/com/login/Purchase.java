package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Purchase extends HttpServlet {
    Connection conn;
    

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       
        String accname = request.getParameter("name");
        String cvv = request.getParameter("cvv");
        String accno = request.getParameter("accountno");   
       
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
            String query2 = "select c_id from curr_cart where email='"+Cookiecls.email+"'";
            //System.out.println(query);
            ResultSet rs2 = st.executeQuery(query2);
            int c_id=0;
            while(rs2.next()) {
            	c_id=rs2.getInt("c_id");
            	 }
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
            String query = "insert into purchase(email, c_id, name, account_no, cvv) values(?, ?, ?, ?, ?)";
            PreparedStatement pStatement = conn.prepareStatement(query);
            pStatement.setString(1, email);
            pStatement.setInt(2, c_id);
            pStatement.setString(3, accname);
            pStatement.setString(4, accno);
            pStatement.setString(5,cvv);
            pStatement.execute();
            pStatement.clearParameters();
            String query1="insert into curr_cart(email) values('"+email+"')";
            int rs3=st.executeUpdate(query1); 
            String query3="delete from curr_cart where c_id="+c_id;
            int rs4=st.executeUpdate(query3);
            String query4 = "select * from products,cart where products.product_id=cart.p_id and cart.c_id="+c_id;
            //System.out.println(query);
            ResultSet rs5 = st.executeQuery(query4);
            while (rs5.next()) {
            	Statement st2 = conn.createStatement();
            	int p_id=rs5.getInt("product_id");
            	int quantity=rs5.getInt("availability");
            	int currquantity=rs5.getInt("quantity");
            	String query5="update products set availability="+Integer.toString(quantity-currquantity)+"where product_id="+p_id+"";
            	int rs6=st2.executeUpdate(query5);
            	System.out.print(p_id);
            }
            
            HttpSession session = request.getSession();
            session.setAttribute("invalid", "Product Ordered Successfully ");
			response.sendRedirect("home.jsp");}
            //out.println("<h1>Purchased Successfully!</h1>");
            //response.sendRedirect("home.jsp");
          //  pStatement.close();
         catch (SQLException e) {
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
