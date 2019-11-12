package com.easytech.nataly_cakes.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easytech.nataly_cakes.beans.UserDataCashe;
import com.easytech.nataly_cakes.cashe.ICacheManager;

@Component
@WebFilter("/*")

public class LoginFilter implements Filter {

	@Autowired
	private ICacheManager cacheManager;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String path = ((HttpServletRequest) request).getRequestURI();
		HttpServletRequest req = (HttpServletRequest) request;

		if (path.startsWith("/user") && req.getMethod().equalsIgnoreCase("post")) {

			chain.doFilter(request, response); // Just continue chain.
			return;

		} 
		if (path.startsWith("/product") && req.getMethod().equalsIgnoreCase("get")) {

			chain.doFilter(request, response); // Just continue chain.
			return;

		}
		else {
			
			Integer token = Integer.parseInt(req.getParameter("token"));

			UserDataCashe userData = (UserDataCashe) cacheManager.get(token);

			if (userData != null) {
				request.setAttribute("userData", userData);
				chain.doFilter(request, response);
				return;
			}
			HttpServletResponse res = (HttpServletResponse) response;

			// 401 = Unauthorized http error code
			res.setStatus(401);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void destroy() {

	}

}
