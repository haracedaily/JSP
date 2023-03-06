<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../../includes/sidebar.jsp" %>
    <%@ include file = "../../includes/top.jsp" %>
    
<%MemberVO vo =(MemberVO)request.getAttribute("member");%>
<h3>조회 결과 (memberSearchOutput.jsp)</h3>
<p>아이디 : <%=vo.getId() %></p>
<p>이름 : <%=vo.getName() %></p>
<p>비밀번호 : <%=vo.getPw() %></p>
<p>메일 : <%=vo.getMail() %></p>

<a href="memberSearchForm.do">회원 검색으로 돌아가기</a>
    <%@ include file = "../../includes/footer.jsp" %>
