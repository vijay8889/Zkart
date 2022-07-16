package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Conf extends HttpServlet {
    Connection conn;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("name");
        Cookiecls.name =name;
        String details = request.getParameter("details");
        
        PrintWriter out=response.getWriter();
        out.println("<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>\r\n"
        		+ "<title>\r\n"
        		+ "Login page\r\n"
        		+ "</title>\r\n"
        		+ "<meta charset=\"UTF-8\">\r\n"
        		+ "<link rel = \"stylesheet\"  href=\"style.css\" media = \"screen\" />\r\n"
        		+ "    \r\n"
        		+ "</head>\r\n"
        		+ "<style>\r\n"
        		+ "body {\r\n"
        		+ "  font-family: Arial;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "input {\r\n"
        		+ "  width: 80%;\r\n"
        		+ "  padding: 12px 20px;\r\n"
        		+ "  margin: 8px 0;\r\n"
        		+ "  display: block;\r\n"
        		+ "  border: 1px solid #ccc;\r\n"
        		+ "  border-radius: 10px;\r\n"
        		+ "  box-sizing: border-box;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "input[type=submit] {\r\n"
        		+ "  width: 80%;\r\n"
        		+ "  background-color: #04AA6D;\r\n"
        		+ "  color: white;\r\n"
        		+ "  padding: 14px 20px;\r\n"
        		+ "  margin: 8px 0;\r\n"
        		+ "  border: none;\r\n"
        		+ "  border-radius: 10px;\r\n"
        		+ "  cursor: pointer;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "input[type=submit]:hover {\r\n"
        		+ "  background-color: #45a049;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "div.containerss {\r\n"
        		+ "  border-radius: 5px;\r\n"
        		+ "  background-color: #f2f2f2;\r\n"
        		+ "  padding: 50px;\r\n"
        		+ "  margin : auto;\r\n"
        		+ "  height: 500px;\r\n"
        		+ "  width:500px;\r\n"
        		+ "  \r\n"
        		+ "}\r\n"
        		+ "</style>\r\n"
        		+ "\r\n"
        		+ "<body>\r\n"
        		+ "<div class=\"header\">\r\n"
        		+ "    <div class=\"container\">\r\n"
        		+ "    <div class=\"navbar\">\r\n"
        		+ "        <div class=\"logo\">\r\n"
        		+ "            <img src=\"images/logo1.png\" width=\"125px\" height=\"70px\">\r\n"
        		+ "        </div>\r\n"
        		+ "        <nav>\r\n"
        		+ "            <ul id=\"MenuItems\">\r\n"
        		+ "                <li><a href=\"home.jsp\">Home</a></li>\r\n"
        		+ "                \r\n"
        		+ "                \r\n"
        		+ "            </ul>\r\n"
        		+ "        </nav>\r\n"
        		+ "\r\n"
        		+ "<div class=\"containerss\">\r\n"
        		+ "<h1>PURCHASE DETAILS</h1>\r\n"
        		+ "<form action=\"Purchase\" method=\"post\">\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "    <label for=\"accname\">Card Holder Name</label>\r\n"
        		+ "    <input type=\"text\" id=\"accname\" name=\"accname\" >\r\n"
        		+ "    \r\n"
        		+ "     <label for=\"accountno\">Account Number</label>\r\n"
        		+ "    <input type=\"number\" id=\"accountno\" name=\"accountno\" >\r\n"
        		+ "    \r\n"
        		+ "     <label for=\"cvv\">CVV</label>\r\n"
        		+ "    <input type=\"number\" id=\"cvv\" name=\"cvv\" >\r\n"
        		+ "    \r\n"
        		+ "     \r\n"
        		+ "    \r\n"
        		+ "    <form method='post' action='Conf'><input name='details' hidden type='text' value="+details+" ><input type='submit' style='display:inline-block;margin-left:650px;font-size:20px;border-radius:10px;background-color:yellow;border-color:white;color:white;' value='Purchase'/></form>\";\r\n"
        		+ "  </form>\r\n"
        		+ "</div>\r\n"
        		+ "\r\n"
        		+ "</body>\r\n"
        		+ "</html>");
        }
    }   

