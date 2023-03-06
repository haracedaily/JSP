package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.controller.MainControl;
import co.dev.controller.MemberDeleteControl;
import co.dev.controller.MemberDeleteFormControl;
import co.dev.controller.MemberInsertControl;
import co.dev.controller.MemberInsertFormControl;
import co.dev.controller.MemberListControl;
import co.dev.controller.MemberSearchControl;
import co.dev.controller.MemberSearchFormControl;
import co.dev.controller.MemberUpdateControl;
import co.dev.controller.MemberUpdateFormControl;

public class FrontController extends HttpServlet{
	String enc;
	
	//url패턴과 실행 컨트롤러 등록.
	//url - controller : map 등록 및 관리
	Map<String, Control> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("encoding");
		
		map.put("/main.do", new MainControl());
		map.put("/login.do", new LoginControl());
		//회원목록
		map.put("/memberList.do", new MemberListControl());
		//회원등록화면
		map.put("/memberInsertForm.do", new MemberInsertFormControl());
		//회원등록처리
		map.put("/memberInsert.do", new MemberInsertControl());
		//회원조회 화면
		map.put("/memberSearchForm.do", new MemberSearchFormControl());
		//회원 조회
		map.put("/memberSearch.do", new MemberSearchControl());
		//수정조회 화면
		map.put("/memberUpdateForm.do", new MemberUpdateFormControl());
		//회원 수정
		map.put("/memberUpdate.do", new MemberUpdateControl());
		//회원삭제 화면
		map.put("/memberDeleteForm.do", new MemberDeleteFormControl());
		//회원삭제
		map.put("/memberDelete.do", new MemberDeleteControl());
		//사원목록
//		map.put("/empList.do", new EmpListControl()); //결과페이지 : member/empList.jsp
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding(enc);//인코딩 : utf-8로 처리하겠숨 
		
		//url - control 매칭.
		String uri = req.getRequestURI();//http://localhost:8080/HelloWeb/main.do 호출
		//uri = 서버 정보 제외한 project이름 + 호출하려는 url값 ..etc
		String context = req.getContextPath();// /HelloWeb
		String path = uri.substring(context.length()); // /HelloWeb 의 길이 만큼 제외하고 읽어오겠다. 즉 /main.do만
		System.out.println(path);
		
		Control sub = map.get(path); //Parent parent = new Child();
		sub.execute(req, resp);
	}
	
	
	
	
}
