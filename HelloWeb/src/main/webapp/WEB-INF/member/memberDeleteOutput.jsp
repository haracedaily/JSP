<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../../includes/sidebar.jsp" %>
    <%@ include file = "../../includes/top.jsp" %>
<% String message = (String)  request.getAttribute("result"); %>

<h3>삭제 결과</h3>
<p>삭제 결과 : <%=message %></p>
    <%@ include file = "../../includes/footer.jsp" %>
    