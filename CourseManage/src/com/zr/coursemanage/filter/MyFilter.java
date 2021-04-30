package com.zr.coursemanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		//向下转型 ServletRequest 是 HttpServletRequest的父类
				HttpServletRequest req=(HttpServletRequest) arg0;
				HttpServletResponse res=(HttpServletResponse) arg1;
				
				req.setCharacterEncoding("UTF-8");
				res.setContentType("text/html;charset=utf-8");
				
				res.setHeader("Access-Control-Allow-Origin", "*");
				res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
				res.setHeader("Access-Control-Max-Age", "0");
				res.setHeader("Access-Control-Allow-Headers",
		                 "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
				res.setHeader("Access-Control-Allow-Credentials", "true");
				res.setHeader("XDomainRequestAllowed", "1");
				
				arg2.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
