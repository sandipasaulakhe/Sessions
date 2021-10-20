package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/")

public class JdbsServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println(request.getServletPath());
	    //System.out.println(request.getServletContext());
		String user="sandipa";
		
		ArrayList<String> al=new ArrayList<>();
		al.add("rutuja");
		al.add("Aarti");
		al.add("monika");
		al.add("sandipa");
		request.setAttribute("user",user);
		request.setAttribute("friendlist", al);
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("view3.jsp");
		rd.forward(request, response);
		
		
		/*
		 * 
		 * try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch
		 * (ClassNotFoundException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } try(Connection
		 * con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root",
		 * "saulakhe"); Statement st= con.createStatement();) { ArrayList<Student> slist=new
		 * ArrayList<>(); ResultSet rs=st.executeQuery("select * from student");
		 * while(rs.next()) { Student s=new Student(); s.setSid(rs.getInt(1));
		 * s.setName(rs.getString(2)); s.setQualification(rs.getString(3));
		 * s.setPlaced(rs.getString(4)); slist.add(s); } System.out.println(slist);
		 * request.setAttribute("studentlist",slist);
		 * request.setAttribute("user","sandipa"); RequestDispatcher
		 * rd=request.getRequestDispatcher("view2.jsp"); rd.forward(request, response);
		 * 
		 * 
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

