<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../../includes/sidebar.jsp" %>
    <%@ include file = "../../includes/top.jsp" %>
	<%
	//자바 영역; 최상단 language = "java"<<자바를 사용할 수 있는 페이지
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("members");//list 주소값을 반환 받음
	System.out.print(list);
	%>
	<table border = "1" class="table">
	<thead>
	<tr>
	
	<td>ID</td><td>name</td><td>password</td><td>Email</td>
	
	</tr>
	</thead>
	<tbody>
	
	<%
		for(MemberVO member : list){
	%>
	<tr><td><%=member.getId()%></td><td><%=member.getName()%></td>
	<td><%=member.getPw() %></td><td><%=member.getMail() %></td></tr>
	<%		
		}
	%>
	
	</tbody>
	</table>
	<a href="memberInsertForm.do">회원등록페이지</a>
    <%@ include file = "../../includes/footer.jsp" %>