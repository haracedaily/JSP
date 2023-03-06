package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
		PrintWriter out = resp.getWriter();
		
		//get or post 요청을 구분해서 처리.
		//get 이면 조회. post 이면 입력.
		
		//String eid = req.getParameter("empId");
		
		if(req.getMethod().equals("GET")) {
			Map<String, Object> result = dao.getEmpInfo(Integer.parseInt(req.getParameter("empId")));
			Set<String> set = result.keySet(); // 키부분만 set 컬렉션
			for(String key : set) {
				System.out.println("key : " + key +" , val : " + result.get(key));
			}
			out.println(result.get("id"));
			out.println(result.get("salary"));
			out.println(result.get("departmentId"));
			out.println(result.get("fullName"));
			out.println(result.get("firstName"));
			out.println(result.get("lastName"));
		}else if(req.getMethod().equals("POST")) {
//			String id= req.getParameter("emplId");
//			String first = req.getParameter("first");
//			String last = req.getParameter("last");
//			String hire = req.getParameter("hire");
//			String job = req.getParameter("job");
//			String mail = req.getParameter("email");
			Map<String, Object> ma = new HashMap<>();
			dao = new EmpDAO();
			ma.put("id", req.getParameter("emplId"));
			ma.put("first", req.getParameter("first"));
			ma.put("last", req.getParameter("last"));
			ma.put("hire", req.getParameter("hire"));
			ma.put("job", req.getParameter("job"));
			ma.put("mail", req.getParameter("email"));
			
			int res = dao.InsertEmpInfo(ma);
			System.out.println(res);
			if(res>0) {
				System.out.println("생성 성공");
			}
		}
		
		
		//페이지 출력. 사번/이름(이름+성씨)/급여/부서
		
		
//		psmt.setInt(1,(int) insert.get("id"));
//		psmt.setString(2, (String) insert.get("first"));
//		psmt.setString(3, (String) insert.get("last"));
//		psmt.setDate(4, (Date) insert.get("hire"));
//		psmt.setInt(5, (int) insert.get("job"));
//		psmt.setString(6, (String) insert.get("mail"));
//		사원 번호 : <input type="text" name="emplId"><br>
//		firstName : <input type="text" name="first"><br>
//		lastName : <input type="text" name="last"><br>
//		입사일자 : <input type="date" name="hire"><br>
//		직무 : <input type="text" name="job"><br>
//		이메일 : <input type="text" name="email"><br>
		
		out.print("<a href='temp.html'>조회, 목록으로 돌아가기</a>");
	}
	
	
}
