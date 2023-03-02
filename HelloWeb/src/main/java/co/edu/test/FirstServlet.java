package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//자바소스 : http 통신 방법을 활용해서 요청 정보와 응답 정보를 생성처리하는데
// HttpServlet 클래스를 상속받아서 사용함.
public class FirstServlet extends HttpServlet{
	//서블릿 라이브러리는 톰캣이 가지고 있음
	//서블릿의 실행 : 개발자 X, Tomcat 컨테이너가 제어(Inversion Of Control:제어의 역전)
	//순서 : 객체 -> init -> service -> destroy
	
	public FirstServlet() {
		//생성자 호출은 서블릿이 호출될 때 한번만 실행..
		System.out.println("생성자 호출. FirstServlet");
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//init 호출은 서블릿이 호출될때 한번만 실행
		System.out.println("init 호출. FirstServlet");
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//service 호출은 서블릿이 호출될때마다 실행.
		System.out.println("Service 호출. FirstServlet");
		if(req.getMethod().equals("GET")) {
			doGet(req, resp);
		}else if(req.getMethod().equals("POST")) {
			doPost(req,resp);
		}
	}
	
	@Override
	public void destroy() {
		//destroy 호출은 서버를 중지 시킬때 한번 실행됨
		System.out.println("destroy 호출. FirstServlet");
	}
	
	//클라이언트 - > 서버요청 : get or post.
	//주소 입력 or link : get 방식
	//doget <- 겟 방식처리하는 메소드; request & response
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get : 주소창 : url, a href="",<form method="get">
		//특징 : url 사용자가 입력값 노출. 용량제한.
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		//응답정보 -> 클라이언트
		resp.setContentType("text/html; charset = utf-8");
		PrintWriter out = resp.getWriter();//출력스트림 생성.
		out.print("<h3>Get방식 요청</h3>");
		//사용자 입력했던 값을 읽어오는 방법.
		//요청 정보에 있다.<<사용자가 입력한 값
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		out.print("<p>입력 id : "+id+" , 비번 : "+pw+"</p>");
		
		out.close();
		//리소스 반환시킨다<<항상 사용하고 닫아주기
		//HttpServletResponse 객체
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset = utf-8");
		PrintWriter out = resp.getWriter();//출력스트림 생성.
		out.print("<h3>Post방식 요청</h3>");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		out.print("<p>입력 id : "+id+" , 비번 : "+pw+"</p>");
		
		out.close();
		out.close();
//		super.doPost(req, resp);
	}
	
}
