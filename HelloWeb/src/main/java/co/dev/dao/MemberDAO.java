package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.common.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO{
	
	public int deleteMember(String id) {
		getConn();
		String sql = "delete from members where id =?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r=psmt.executeUpdate();
			
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConn();
		}
		return 0;
		
	}
	
	public int updateMember(MemberVO vo) {
		getConn();
		String sql = "update members set name=? ,passwd = ? ,mail=? where id=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getMail());
			psmt.setString(4, vo.getId());
			
			int r=psmt.executeUpdate();
			
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConn();
		}
		return 0;
	}
	
	public MemberVO selectMember(String id){
		
		getConn();
		String sql ="select * from members where id = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs=psmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("passwd"));
				vo.setMail(rs.getString("mail"));
				
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConn();
		}
		return null;
	}
	
	//회원등록.
	public int insertMember(MemberVO vo) {
		
		getConn();
		String sql = "insert into members(id,name,passwd,mail) values(?,?,?,?)";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPw());
			psmt.setString(4, vo.getMail());
			
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disConn();
		}
		return 0;//처리 안될 경우 catch 지나서 넘어옴>? 이왜진
	}
	
	
	//회원 목록
	public List<MemberVO> memberList(){
		List<MemberVO> list = new ArrayList<>();
			getConn();
			String sql = "select * from members order by id";
		try {
			psmt = conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("passwd"));
				vo.setMail(rs.getString("mail"));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConn();
		}
		return list;
	}
	
	
	
	
	
	
}
