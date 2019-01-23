package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
/**
 * Servlet implementation class UsernameValidationServlet
 */
@WebServlet("/UsernameValidationServlet")
public class UsernameValidationServlet extends HttpServlet {
	

	

	 private static final long serialVersionUID = -734503860925086969L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        try {

	            String connectionURL = "jdbc:mysql://localhost:3306/amazone"; // students is my database name
	            Connection connection = null;
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            connection = DriverManager.getConnection(connectionURL, "root", "admin");
	            String uname = request.getParameter("uname");
	            PreparedStatement ps = connection.prepareStatement("select userId from user_table where userId=?");
	            ps.setString(1,uname);
	            ResultSet rs = ps.executeQuery();
	             
	            if (!rs.next()) {
	                out.println("<font color=green><b>"+uname+"</b> is avaliable");
	            }
	            else{
	            out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
	            }
	            out.println();



	        } catch (Exception ex) {

	            out.println("Error ->" + ex.getMessage());

	        } finally {
	            out.close();
	        }
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
	}
