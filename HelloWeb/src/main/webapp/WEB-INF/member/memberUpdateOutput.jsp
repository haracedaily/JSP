<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 결과</title>
</head>
<body>
<% String message = (String)  request.getAttribute("message"); %>
<%MemberVO vo = (MemberVO)request.getAttribute("result"); %>
<h3>수정 결과</h3>
<p>수정 결과 : <%=message %></p>
<%if(message.equals("정상 처리 완료")){ %>
<p>변경완료 된 정보</p>
<p>id : <%=vo.getId() %></p>
<p>name : <%=vo.getName() %></p>
<p>pw : <%=vo.getPw() %></p>
<p>mail : <%=vo.getMail() %></p>
<%}else{ %>
<p>변경 전 정보</p>
<p>id : <%=vo.getId() %></p>
<p>name : <%=vo.getName() %></p>
<p>pw : <%=vo.getPw() %></p>
<p>mail : <%=vo.getMail() %></p>
<%} %>
<a href="memberUpdateForm.do">수정조회로 돌아가기</a>
</body>
</html>