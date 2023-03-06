package co.dev.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MainControl implements Control{
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("main");
		RequestDispatcher rd = req.getRequestDispatcher("main/main.jsp");
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//페이지 재지정. 
	}
	
	
	
}
