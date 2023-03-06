package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{
	String str;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		int num=0;
//		String str = req.getParameter("msg");
		str = req.getParameter("msg");
		out.print("<h3>처리결과</h3>");
		while(num++<10) {
			out.print(str+" : "+num + "<br>");
			out.flush();//메모리를 지움
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h3>Done</h3>");
		out.close();
		
		//상태유지 기술.
		//http: 요청 -> 응답 : 요청 및 응답은 메모리에서 사라짐.
		//client A: 요청 -> 응답.
		//client B: 요청 -> 응답.
		//클라이언트 vs 서버
		//쿠키     vs 요청, 세션, 컨텍스트(애플리케이션)
		//WAS=톰캣 웹 어플리케이션
		//서블릿 콘텍스트 <- 각각의 웹 어플리케이션마다 가짐;각각의 웹 어플리케이션의 정보를 담음.
		//서블릿 콘텍스트와 웹 어플리케이션은 서로간의 데이터를 공유가 가능
		//톰캣은 서블릿 콘텍스트들의 총합(즉 관리함)
		
		//context ≒ 어플리케이션; why? 어플리케이션마다 존재해서
		
		//어플리케이션 컨텍스트(어플리케이션 생성되는 객체)
		// /servletConfigTest, /servletCoonfig
		// context에 param : 값. context에 값을 불러.
		//setAttribute("param"), getAttribute("param")
		
		//session : 접속하는 유저별(로그인), request :요청하는 페이지마다()√
		
		
		
		//https://tmxhsk99.tistory.com/135
	}
	
}
