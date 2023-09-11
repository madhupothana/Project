package com.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "CustomerFilter", urlPatterns = { "/proceed","/Login","/check","/details","/newapplication","/afterEmi","/save"})

public class CustomerFilter extends HttpFilter implements Filter {

	public CustomerFilter() {
		super();

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// Check if a session exists; if not, create one
		HttpSession session = httpRequest.getSession();

		String userType=(String) session.getAttribute("loggedUser");
		String userName = request.getParameter("email");
		String password = request.getParameter("password");
	System.out.println("sat3");
		if ((userName != null && password != null && userType.equals("customer")) || userType.equals("customer")) {
			System.out.println("sat4");
			chain.doFilter(request, response);}
		else {
			System.out.println("Invaid Login Details");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
