package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	
	public void connect() {
		try {
		String url= "jdbc:oracle:thin:@localhost:1521:xe";
		String id= "hr";
		String pw= "hr";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> getEmpInfo(int empId){
		
		Map<String, Object> result = new HashMap<>();
		connect();
		String sql = "select employee_id,first_name,last_name,salary,department_id,first_name||' '||last_name AS name from employees where employee_id=?";
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1,empId);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			result.put("id", rs.getInt("employee_id"));
			result.put("firstName", rs.getString("first_name"));
			result.put("lastName",rs.getString("last_name"));
			result.put("salary", rs.getInt("salary"));
			result.put("departmentId", rs.getInt("department_id"));
			result.put("fullName", rs.getString("name"));
			
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return result;
}
	
	
//	사원 번호 : <input type="text" name="emplId"><br>
//	firstName : <input type="text" name="first"><br>
//	lastName : <input type="text" name="last"><br>
//	입사일자 : <input type="date" name="hire"><br>
//	직무 : <input type="text" name="job"><br>
//	이메일 : <input type="text" name="email"><br>
	
public int InsertEmpInfo(Map<String, Object> insert){
		
		int result = 0;
		connect();
		String sql = "insert into employees(employee_id,first_name,last_name,hire_date,job_id,email) values(?,?,?,?,?,?)";
		try {//오류난게 관계키 설정 되 있어서 나는거 였...
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, (String) insert.get("id"));
		psmt.setString(2, (String) insert.get("first"));
		psmt.setString(3, (String) insert.get("last"));
		psmt.setString(4, (String) insert.get("hire"));
		psmt.setString(5, (String) insert.get("job"));
		psmt.setString(6, (String) insert.get("mail"));
	
		result = psmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return result;
}
	


	
}