package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hide1")

public class Demohidden extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
			String s=req.getParameter("fname");
			out.println("<html><body>");
			out.print("<h1>hi Welcome hidden rewriting demo</h1>");
			out.print("<form action='hide2'>");
			out.print("<input type='hidden' name='username' value='sandipa'>");
			out.println("<a href='hi?unm=sandipa'>Next</a>");
			out.print("<input type='submit' value='submit'");
			
			out.print("</body></html>");
		}
		}


