package com.ifrn.ocorrenciasJoseRicardo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptador implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("login")) {
			return true;
		}
		
		if(request.getSession().getAttribute("usuario")!= null) {
			return true;
		}
		
		response.sendRedirect("/login");
		return false;
	}
	
	

}
