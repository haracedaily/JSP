package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/headerInfo","/headInfo"})
public class HeaderInfoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	
	String html ="<html><head><title>Header 정보</title></head>";
			html +="<body>";
	html+="<h3>요청 헤더 정보 </h3>";
	
	Enumeration<String> em = req.getHeaderNames();//헤더정보 전체 가지고 오기.
	//반복된 요소를 가지고 있습니다
	
	while(em.hasMoreElements()) {
		String head = em.nextElement();
		html+=head+" : " + req.getHeader(head)+"<br>";
	}
	html+="</body></html>";
	
	out.print(html);
	out.close();
	}
}
