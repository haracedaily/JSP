package co.dev.service;

import java.util.List;

import co.dev.vo.MemberVO;

public interface MemberService {
	//회원 목록.
	public List<MemberVO> getMembers();
	//회원등록.
	public boolean addMember(MemberVO vo);
	
	public MemberVO getMember(String id);
	
	public int modifyMember(MemberVO vo);
	
	public boolean removeMember(String id);
}
