package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MemberInsertFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		// 회원등록화면 호출.
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/member/memberInsert.jsp");
		try {
			rd.forward(req, resp);//요청을 재지정한다 ? dispatcher에서 지정한 경로를 재지정..? 뭔말이야 진짜
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
