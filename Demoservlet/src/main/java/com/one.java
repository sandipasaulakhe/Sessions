package com;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")

public class one extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	
	

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.getWriter().println("hi from tqpp"); 
	HashMap<String,Integer> swiggy=new HashMap<>();
	swiggy.put("Pav bhaji", 2);
	swiggy.put("Dosa", 3);
	req.setAttribute("orderlist", swiggy);
	RequestDispatcher rd=req.getRequestDispatcher("second");
	rd.forward(req, resp);
}
}


