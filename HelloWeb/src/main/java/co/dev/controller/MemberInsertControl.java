package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		
		// TODO Auto-generated method stub
		//회원정보 등록 : 서비스 로직에 등록할 것 : MemberService[등록] -> MemberDAO[처리]
		MemberService service = new MemberServiceImpl();
		//사용자가 입력한 값(파라미터명: id, pass, name, mail)
		MemberVO vo = new MemberVO();
		String id = req.getParameter("id");
		String pw = req.getParameter("pass");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		vo.setId(id);
		vo.setName(name);
		vo.setPw(pw);
		vo.setMail(mail);
		System.out.println("입력 : "+vo);
		
		boolean result = service.addMember(vo);
		System.out.println(result);
		if(result==true) {
			System.out.println("성공");
			req.setAttribute("message", "성공");
			req.setAttribute("id", vo.getId());
		}else {
			System.out.println("예외");
			req.setAttribute("message", "예외");
		}
		//요청 재지정하는 requsetDispatcher를 사용
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/member/memberInsertOutput.jsp");
		
		try {
			rd.forward(req, resp);//경로 재지정한 걸 실행하려면 사용 한다.
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
