<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../../includes/sidebar.jsp" %>
    <%@ include file = "../../includes/top.jsp" %>
	<%
	 Object obj = request.getAttribute("message");//object 타입으로 데리고 넘어옴
	 String result = (String) obj;
	 String id = (String) request.getAttribute("id");//String 타입으로 바로 캐스팅
	%>
	<p> 처리결과 : <%=result %></p>
	<p> ID : <%=id %>님의 가입을 환영합니다!</p>

	<p>회원 목록으로 이동</p>
	<a href="memberList.do">이동</a>
    <%@ include file = "../../includes/footer.jsp" %>
    