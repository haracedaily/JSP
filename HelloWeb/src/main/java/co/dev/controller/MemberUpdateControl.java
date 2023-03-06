package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(req.getParameter("id"));
		vo.setPw(req.getParameter("pw"));
		vo.setName(req.getParameter("name"));
		vo.setMail(req.getParameter("mail"));
		
		int r=service.modifyMember(vo);
		if(r>0) {
			req.setAttribute("message", "정상 처리 완료");
			req.setAttribute("result", vo);
			
		}else {
			req.setAttribute("message", "예외 발생");
			req.setAttribute("result", service.getMember(vo.getId()));
		}
		
		try {
			req.getRequestDispatcher("WEB-INF/member/memberUpdateOutput.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
