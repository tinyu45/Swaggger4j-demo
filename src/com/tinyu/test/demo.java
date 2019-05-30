package com.tinyu.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONWriter;
import com.cpjit.swagger4j.annotation.API;
import com.cpjit.swagger4j.annotation.APIs;
import com.cpjit.swagger4j.annotation.Param;
@APIs("/demo")
@WebServlet(name = "demoServlet", urlPatterns = { "/demo" })
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@API(value="", summary = "测试",  method = "GET", parameters = {
			@Param( name="token", type="string",  required=true,   description="用户标识符", in="header", defaultValue="34543654654"  ),
			@Param(name = "username", type = "string", description = "用户名"),
			@Param(name = "password", type = "string", description = "密码", format="password")
	})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());
		Map<String, String> user = new HashMap<String, String>();
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		user.put("username", username);
		user.put("password", pwd);
		writer.writeObject(user);
		writer.flush();
		writer.close();
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print(request.getParameter("username"));;
	}

}
