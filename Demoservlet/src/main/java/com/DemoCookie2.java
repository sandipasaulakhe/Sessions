package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/cook2")

public class DemoCookie2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.print("<h1>hi Welcome cookie demo</h1>");
		Cookie[] arr=request.getCookies();
		
		for(Cookie c:arr)
		{
			
			out.println(c.getName()+ "-->" + c.getValue());
		}
		//out.println()
		out.print("</body></html>");
	}

	
	

}


