package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//컨텐트 타입 지정; json, html 지정해줘야함
		req.setCharacterEncoding("utf-8");//요청정보의 인코딩 방식 지정.
		resp.setCharacterEncoding("utf-8");//응답정보의 인코딩 방식 지정.
		
		
		//사용자가 값을 여러개 전송.
		//각 값을 system.out.print(콘솔에 출력)
		PrintWriter out = resp.getWriter();
		String id =req.getParameter("id");//guest
		String pw = req.getParameter("pwd");//1234
		String name = req.getParameter("name");//kr
		String hobby = req.getParameter("hobby");//4개
		String gender = req.getParameter("gender");//1ea
		String rel=req.getParameter("religion");//1ea
		String introduce = req.getParameter("introduction");//kr
		
		
		
		System.out.println("id : "+id+"\npw : "+pw);
		System.out.println("name : "+name);
		System.out.println("gender : "+gender);
		System.out.println("hobby : "+hobby);
		System.out.println("rel : "+rel);
		System.out.println("자기소개 : "+introduce);
		
		out.print("결과");
		out.println("id : "+id+"\npw : "+pw);
		out.println("name : "+name);
		out.println("gender : "+gender);
		out.println("hobby : "+hobby);
		out.println("rel : "+rel);
		out.println("자기소개 : "+introduce);
		
		out.close();
	}
}
