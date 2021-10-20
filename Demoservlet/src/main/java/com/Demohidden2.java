package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hide2")

public class Demohidden2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out=resp.getWriter();
		
		out.println("<html><body>");
		out.print("<h1>hi Welcome hidden page 2 demo</h1>");
		String str=req.getParameter("username");
		out.print(str);
	}
	}


