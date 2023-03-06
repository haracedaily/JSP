package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("id");//입력 받은 값 넘겨받는 용도
		String job = req.getParameter("job");
		//id를 활용해서 membervo객체를 반환하는 메소드가 필요함.
		MemberService service = new MemberServiceImpl();//메소드 호출용
		MemberVO vo = new MemberVO();//결과값 받는 용도
		
		
		String targetPage = "";
		
		if(job.equals("search")) {
		vo=service.getMember(id);//호출하는데 입력받은 값 사용해서 호출하고 결과값 받는용도랬던 vo에 저장
		req.setAttribute("member", vo);//메소드 결과물 저장하는 용도//vo를 저장
		if(vo == null) {
			req.setAttribute("message", "조회된 결과가 없습니다.");
			targetPage="WEB-INF/member/memberSearchForm.jsp";
		}else {
			targetPage="WEB-INF/member/memberSearchOutput.jsp";
		}
		}else if(job.equals("update")) {
			vo=service.getMember(id);
			req.setAttribute("vo", vo);
			targetPage="WEB-INF/member/memberUpdate.jsp";
			if(vo == null) {
				req.setAttribute("message", "조회된 결과가 없습니다.");
				targetPage="WEB-INF/member/memberUpdate.jsp";
			}else {
				targetPage="WEB-INF/member/memberUpdate.jsp";
			}
		}else if(job.equals("delete")) {
			vo=service.getMember(id);
			req.setAttribute("dm", vo);
		if(vo==null) {
			req.setAttribute("message", "조회된 결과가 없습니다.");
			targetPage="WEB-INF/member/memberDelete.jsp";
		}else {
			targetPage="WEB-INF/member/memberDelete.jsp";
		}
		}
		
			
		try {
			req.getRequestDispatcher(targetPage).forward(req, resp);//메소드 결과물 공유할 위치
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
