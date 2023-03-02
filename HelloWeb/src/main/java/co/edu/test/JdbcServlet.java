package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmpDAO dao = new EmpDAO();
		Map<String, Object> result = dao.getEmpInfo(Integer.parseInt(req.getParameter("empId")));
		
		//페이지 출력. 사번/이름(이름+성씨)/급여/부서
		PrintWriter out = resp.getWriter();
		
		out.println(result.get("id"));
		out.println(result.get("salary"));
		out.println(result.get("departmentId"));
		out.println(result.get("fullName"));
		out.println(result.get("firstName"));
		out.println(result.get("lastName"));
		
		
		
	}
	
	
}
