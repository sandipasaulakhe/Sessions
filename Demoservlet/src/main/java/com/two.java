package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class two extends HttpServlet {
	@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out=resp.getWriter();
	HashMap<String,Integer> hm=(HashMap<String, Integer>) req.getAttribute("orderlist");
     for(String k:hm.keySet())
     {
    	 out.println("key "+k + " value : "+hm.get(k));
     }
}
}


